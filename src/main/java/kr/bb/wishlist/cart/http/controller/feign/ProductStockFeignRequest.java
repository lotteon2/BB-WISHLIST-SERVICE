package kr.bb.wishlist.cart.http.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "get-product-stock",url = "${service.product.domain}")
public interface ProductStockFeignRequest {

  @GetMapping("/products/{productId}")
  public ResponseEntity<Integer> getProductStock(@PathVariable String productId);

}
