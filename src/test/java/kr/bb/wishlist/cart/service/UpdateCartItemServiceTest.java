package kr.bb.wishlist.cart.service;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.exception.CartDomainException;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateCartItemServiceTest {

  @Mock
  private CartJpaRepository repository;
  @InjectMocks
  private UpdateCartItemSelectedQuantityProcessor processor;
  @Mock
  private IncreaseCartItemSelectedQuantityStrategy increaseCartItemSelectedQuantityStrategy;
  @Mock
  private DecreaseCartItemSelectedQuantityStrategy decreaseCartItemSelectedQuantityStrategy;


  @DisplayName("1개 미만으로 수량을 조절할 때 Throw CartDomainException")
  @Test
  void UpdateCartItemSelectedQuantity_WhenUpdateUnder1_ThrowCartDomainException() {
    CartCompositeKey cartCompositeKey = new CartCompositeKey(1L, 1L);
    CartEntity cartEntity = new CartEntity(cartCompositeKey, 3);

    assertThrowsExactly(CartDomainException.class, () -> {
      processor.update(cartEntity, cartEntity.getSelectedQuantity(), 0, 3);
    });

  }


  @DisplayName("총 업데이트할 개수가 재고보다 많은 경우 재고만큼 업데이트")
  @Test
  void UpdateCartItemSelectedQuantity_WhenStockIsNotEnough_UpdateAsStockQuantity() {
    CartCompositeKey cartCompositeKey = new CartCompositeKey(1L, 1L);
    CartEntity cartEntity = new CartEntity(cartCompositeKey, 3);

    processor.update(cartEntity, cartEntity.getSelectedQuantity(), 5, 4);

    verify(decreaseCartItemSelectedQuantityStrategy, never()).decreaseCartItemSelectedQuantity(
        cartEntity, 4, 5);
    verify(increaseCartItemSelectedQuantityStrategy, never()).increase(cartEntity, 4, 5);
    verify(repository, times(1)).save(any());
  }

  @DisplayName("현재 고른 개수보다 더 작고, 1개 미만으로 요청하지 않을 시 decreaseCartItemSelectedQuantityStrategy called")
  @Test
  void UpdateCartItemSelectedQuantity_WhenDecreaseQuantityAndNotUnder0_decreaseCartItemSelectedQuantityStrategyMethodCall() {
    CartCompositeKey cartCompositeKey = new CartCompositeKey(1L, 1L);
    CartEntity cartEntity = new CartEntity(cartCompositeKey, 3);

    processor.update(cartEntity, cartEntity.getSelectedQuantity(), 2, 4);

    verify(decreaseCartItemSelectedQuantityStrategy, times(1)).decreaseCartItemSelectedQuantity(
        any(), anyInt(), anyInt());

  }


  @DisplayName("재고가 충분하고 현재 고른 개수보다 더 많은 경우 increaseCartItemSelectedQuantityStrategy called")
  @Test
  void UpdateCartItemSelectedQuantity_WhenStockIsEnoughAndIncreaseQuantity_IncreaseCartItemSelectedQuantityStrategyMethodIsCalled() {
    CartCompositeKey cartCompositeKey = new CartCompositeKey(1L, 1L);
    CartEntity cartEntity = new CartEntity(cartCompositeKey, 3);

    processor.update(cartEntity, cartEntity.getSelectedQuantity(), 6, 10);

    verify(increaseCartItemSelectedQuantityStrategy, times(1)).increase(any(CartEntity.class),
        anyInt(), anyInt());
  }


}