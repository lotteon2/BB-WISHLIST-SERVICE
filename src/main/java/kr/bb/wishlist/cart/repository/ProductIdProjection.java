package kr.bb.wishlist.cart.repository;

public interface ProductIdProjection {

    Long getProductId();

    static ProductIdProjection createFromLong(Long productId) {
        return () -> productId;
    }
}
