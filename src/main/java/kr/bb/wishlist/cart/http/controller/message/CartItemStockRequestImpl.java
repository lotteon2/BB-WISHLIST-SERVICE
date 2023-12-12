package kr.bb.wishlist.cart.http.controller.message;

import kr.bb.wishlist.cart.http.controller.feign.ProductStockFeignRequest;
import kr.bb.wishlist.common.valueobject.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CartItemStockRequestImpl implements CartItemStockMessageRequest<ProductId> {

  private final ProductStockFeignRequest productStockFeignRequest;

  @Override
  public int request(ProductId productId) {
    return productStockFeignRequest.getProductStock(productId.getValue()).getBody();
  }
}
