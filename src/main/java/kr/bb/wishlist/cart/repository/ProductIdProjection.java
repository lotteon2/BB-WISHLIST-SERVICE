package kr.bb.wishlist.cart.repository;


import kr.bb.wishlist.common.valueobject.ProductId;

@FunctionalInterface
public interface ProductIdProjection {

    ProductId getProductId();

    static ProductIdProjection createFromLong(ProductId productId) {
        return () -> productId;
    }
}
