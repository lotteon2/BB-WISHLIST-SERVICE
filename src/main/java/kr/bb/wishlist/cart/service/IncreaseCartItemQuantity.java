package kr.bb.wishlist.cart.service;

import java.util.Optional;
import kr.bb.wishlist.cart.entity.CartCompositekey;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.mapper.CartMapper;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import kr.bb.wishlist.cart.util.CartCompkeyMakerUtil;
import kr.bb.wishlist.cart.valueobject.AddCartItemStatus;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IncreaseCartItemQuantity implements
    AddCartItemWhenCartItemIsAlreadyExist {

  private final CartJpaRepository repository;

  @Override
  public AddCartItemStatus addCartItem(UserId userId, ProductId productId, int selectedQuantity) {

    Optional<CartEntity> cartEntityOptional = repository.findById(
        CartCompkeyMakerUtil.cartEntityCompKey(userId, productId));

    if (cartEntityOptional.isPresent()) {
      increaseSelectedQuantityWhenCartIsExist(cartEntityOptional.get(), selectedQuantity);
      return AddCartItemStatus.ALREADY_EXIST;
    } else {
      saveWhenCartItemIsNotExist(userId, productId, selectedQuantity);
      return AddCartItemStatus.NEW_CART_ITEM;
    }
  }

  private void saveWhenCartItemIsNotExist(UserId userId, ProductId productId,
      int selectedQuantity) {
    repository.save(CartEntity.builder()
        .cartCompositekey(CartCompkeyMakerUtil.cartEntityCompKey(userId, productId))
        .selectedQuantity(selectedQuantity).build());
  }

  private void increaseSelectedQuantityWhenCartIsExist(CartEntity cartEntity,
      int increasedQuantity) {
    repository.save(CartMapper.getCartEntityWithUpdatedSelectedQuantity(cartEntity,
        cartEntity.getSelectedQuantity() + increasedQuantity));
  }

}
