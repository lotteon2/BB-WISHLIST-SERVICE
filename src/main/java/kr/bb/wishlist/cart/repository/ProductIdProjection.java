package kr.bb.wishlist.cart.repository;


@FunctionalInterface
public interface ProductIdProjection {

    String getProductId();

    static ProductIdProjection createFromLong(String productId) {
        return () -> productId;
    }
}
