package kr.bb.wishlist.wish.util;

import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.wish.entity.ProductLikesCompositeKey;

public class ProductLikesCompKeyMaker {
  private ProductLikesCompKeyMaker(){

  }
  public static ProductLikesCompositeKey get(ProductId productId, UserId userId){
    return new ProductLikesCompositeKey(userId.getValue(),productId.getValue());
  }
}
