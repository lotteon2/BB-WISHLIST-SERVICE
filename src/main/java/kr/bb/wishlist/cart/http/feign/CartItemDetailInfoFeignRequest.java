package kr.bb.wishlist.cart.http.feign;

import bloomingblooms.response.CommonResponse;
import java.util.Map;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "get-cart-items-detail", url = "${service.product.domain}")
public interface CartItemDetailInfoFeignRequest {

  @PostMapping("/client/products/carts")
  CommonResponse<GetUserCartItemsResponse> getCartItemDetails(
      @RequestBody Map<String, Long> productIdWithSelectedQuantity);
}
