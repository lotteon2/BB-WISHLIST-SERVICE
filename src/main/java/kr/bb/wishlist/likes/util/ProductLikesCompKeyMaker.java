package kr.bb.wishlist.likes.util;

import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.ProductLikesCompositeKey;

public class ProductLikesCompKeyMaker {
  private ProductLikesCompKeyMaker(){

  }
  public static ProductLikesCompositeKey get(ProductId productId, UserId userId){
    return new ProductLikesCompositeKey(userId.getValue(),productId.getValue());
  }
}
