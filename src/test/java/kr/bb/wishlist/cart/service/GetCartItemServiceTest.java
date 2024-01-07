package kr.bb.wishlist.cart.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import kr.bb.wishlist.cart.dto.CartItemProductIdDto;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.exception.CartDomainException;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import kr.bb.wishlist.cart.repository.ProductIdProjection;
import kr.bb.wishlist.common.valueobject.UserId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetCartItemServiceTest {

  @Mock
  private ProductIdProjection productIdProjectionMock;

  @InjectMocks
  private CartServiceImpl cartService;
  @Mock
  private CartJpaRepository repository;

  @Test
  void GetCartItem_WhenThereIsProduct_GetCartItemInfoWithDto() {
    CartEntity cartEntity = mock(CartEntity.class);
    CartCompositeKey compositeKey = mock(CartCompositeKey.class);
    when(cartEntity.getCartCompositekey()).thenReturn(compositeKey);

    List<CartEntity> cartEntityList = List.of(cartEntity);

    when(repository.findAllByCartCompositekey_UserId(any())).thenReturn(cartEntityList);

    when(cartEntity.getCartCompositekey()).thenReturn(compositeKey);

    CartItemProductIdDto dto = cartService.getCartItem(new UserId(anyLong()));

    verify(repository).findAllByCartCompositekey_UserId(any());

    assertNotNull(dto);

  }

  @Test
  void GetCartItem_WhenThereIsProduct_ThrowCartDomainException() {

    when(repository.findAllByCartCompositekey_UserId(anyLong())).thenThrow(
        CartDomainException.class);

    assertThrowsExactly(CartDomainException.class, () -> {
      cartService.getCartItem(new UserId(anyLong()));
    });
  }


}
