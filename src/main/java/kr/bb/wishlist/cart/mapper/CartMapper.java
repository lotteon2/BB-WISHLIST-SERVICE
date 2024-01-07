package kr.bb.wishlist.cart.mapper;

import kr.bb.wishlist.cart.entity.CartEntity;

public class CartMapper {

  public static CartEntity getCartEntityWithUpdatedSelectedQuantity(CartEntity cartEntity,
      Long totalQuantity) {
    return CartEntity.builder().cartCompositekey(cartEntity.getCartCompositekey())
        .selectedQuantity(totalQuantity).build();
  }
}
