package kr.bb.wishlist.likes.util;


import kr.bb.wishlist.common.valueobject.StoreId;

@FunctionalInterface
public interface StoreIdProjection {

  StoreId getStoreId();

  static StoreIdProjection createStoreId(StoreId storeId) {
    return () -> storeId;

  }
}
