package kr.bb.wishlist.wish.util;


@FunctionalInterface
public interface StoreIdProjection {

  Long getStoreId();

  static StoreIdProjection createStoreId(Long storeId) {
    return () -> storeId;

  }
}
