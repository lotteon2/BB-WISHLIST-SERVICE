package kr.bb.wishlist.likes.http.feign;

import bloomingblooms.domain.wishlist.likes.LikedProductInfoResponse;
import bloomingblooms.response.CommonResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "get-product-info", url = "${service.product.domain}")
public interface GetLikedProductInfoFeignRequest {


  @PostMapping("/client/products/likes")
  CommonResponse<LikedProductInfoResponse> getProductDetailWhichUserLiked(
      @RequestBody List<String> productList);

}
