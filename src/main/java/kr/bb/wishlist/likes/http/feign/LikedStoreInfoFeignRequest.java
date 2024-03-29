package kr.bb.wishlist.likes.http.feign;

import bloomingblooms.domain.wishlist.likes.LikedStoreInfoResponse;
import bloomingblooms.response.CommonResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "get-liked-store-info",url = "${service.store.domain}")
public interface LikedStoreInfoFeignRequest {

  @PostMapping("/client/stores/simple-info")
  CommonResponse<List<LikedStoreInfoResponse>> getLikedStoreInfo(@RequestBody List<Long> storeIds);


}
