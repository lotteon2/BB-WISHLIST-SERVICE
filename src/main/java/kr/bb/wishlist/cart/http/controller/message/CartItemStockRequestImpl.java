package kr.bb.wishlist.cart.http.controller.message;

import kr.bb.wishlist.cart.http.controller.feign.ProductStockFeignRequest;
import kr.bb.wishlist.common.valueobject.ProductId;
import org.springframework.stereotype.Component;

@Component
public class CartItemStockRequestImpl implements CartItemStockRequest<ProductId> {
  private final ProductStockFeignRequest productStockFeignRequest;
  @Override
  public int request(ProductId productId) {

  }
}
