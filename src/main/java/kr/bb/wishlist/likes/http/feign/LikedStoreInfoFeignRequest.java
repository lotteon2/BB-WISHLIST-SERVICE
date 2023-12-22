package kr.bb.wishlist.likes.http.feign;

import bloomingblooms.response.CommonResponse;
import kr.bb.wishlist.likes.dto.message.StoreIdListDto;
import kr.bb.wishlist.likes.dto.response.LikedStoreInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "get-liked-store-info",url = "${service.store.domain}")
public interface LikedStoreInfoFeignRequest {

  @GetMapping("/client/stores/likes")
  public CommonResponse<LikedStoreInfoResponse> getLikedStoreInfo(@RequestBody StoreIdListDto storeIdListDto);


}
