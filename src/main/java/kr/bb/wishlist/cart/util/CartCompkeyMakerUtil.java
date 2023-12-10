package kr.bb.wishlist.cart.util;

import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;

public class CartCompkeyMakerUtil {

  public static CartCompositeKey cartEntityCompKey(UserId userId, ProductId productId){
    return new CartCompositeKey(userId.getValue(),productId.getValue());
  }
}
