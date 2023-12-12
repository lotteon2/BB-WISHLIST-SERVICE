package kr.bb.wishlist.cart.repository;

public interface ProductIdProjection {

    String getProductId();

    static ProductIdProjection createFromLong(String productId) {
        return () -> productId;
    }
}
