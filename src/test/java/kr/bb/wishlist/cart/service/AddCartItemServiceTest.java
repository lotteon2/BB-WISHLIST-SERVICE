package kr.bb.wishlist.cart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import kr.bb.wishlist.cart.valueobject.AddCartItemStatus;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddCartItemServiceTest {


 @Mock
 private CartJpaRepository repository;
 @InjectMocks
 private IncreaseCartItemQuantity addCartService;


 @DisplayName("이미 존재하는 카트 상품 개수 추가")
 @Test
 void AddCartItem_WhenCartItemIsAlreadyExistedInCart_StatusAlreadyExist() {

  CartEntity existingCartEntity = new CartEntity(new CartCompositeKey(1L, "1"), 2);
  UserId userId = new UserId(existingCartEntity.getCartCompositekey().getUserId());
  ProductId productId = new ProductId(existingCartEntity.getCartCompositekey().getProductId());

  when(repository.findById(any())).thenReturn(Optional.of(existingCartEntity));

  AddCartItemStatus status = addCartService.addCartItem(userId, productId, 3);

  verify(repository).save(any());

  assertEquals(status, AddCartItemStatus.ALREADY_EXIST);

 }

 @DisplayName("카트에 존재하지 않는 상품 추가")
 @Test
 void AddCartItem_WhenCartItemIsNotExistedInCart_StatusNewCartItem() {
  CartEntity newCartEntity = new CartEntity(new CartCompositeKey(1L, "1"), 2);
  UserId userId = new UserId(newCartEntity.getCartCompositekey().getUserId());
  ProductId productId = new ProductId(newCartEntity.getCartCompositekey().getProductId());

  when(repository.findById(any())).thenReturn(Optional.empty());

  AddCartItemStatus status = addCartService.addCartItem(userId,productId,
      newCartEntity.getSelectedQuantity());

  verify(repository).save(any());

  assertEquals(AddCartItemStatus.NEW_CART_ITEM, status);
 }

}
