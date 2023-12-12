package kr.bb.wishlist.wish.util;

import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.wish.entity.StoreLikesCompositeKey;

public class StoreLikesCompKeyMaker {

  public static StoreLikesCompositeKey get(UserId userId, StoreId storeId) {
    return StoreLikesCompositeKey.builder().storeId(storeId.getValue()).userId(userId.getValue())
        .build();
  }
}
