package kr.bb.wishlist.cart.http.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "get-product-stock", value = "${service.product.domain}")
public interface ProductStockFeignRequest {

}
