package kr.bb.wishlist.cart.http.feign;

import javax.validation.Valid;
import kr.bb.wishlist.cart.dto.CartItemProductIdList;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "get-cart-items-detail", value = "${service.product.domain}")
public interface CartItemDetailInfoFeignRequest {
  @GetMapping("/products/carts")
  public ResponseEntity<GetUserCartItemsResponse> getCartItemDetails(@Valid @RequestBody CartItemProductIdList productIdList);
}
