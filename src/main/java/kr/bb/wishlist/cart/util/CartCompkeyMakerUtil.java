package kr.bb.wishlist.cart.util;

import kr.bb.wishlist.cart.entity.CartCompositekey;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;

public class CartCompkeyMakerUtil {

  public static CartCompositekey cartEntityCompKey(UserId userId, ProductId productId){
    return new CartCompositekey(userId.getValue(),productId.getValue());
  }
}
