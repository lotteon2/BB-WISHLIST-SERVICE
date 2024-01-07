package kr.bb.wishlist.likes.util;

import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;

public class StoreLikesCompKeyMaker {

  private StoreLikesCompKeyMaker(){

  }
  public static StoreLikesCompositeKey get(UserId userId, StoreId storeId) {
    return StoreLikesCompositeKey.builder().storeId(storeId.getValue()).userId(userId.getValue())
        .build();
  }
}
