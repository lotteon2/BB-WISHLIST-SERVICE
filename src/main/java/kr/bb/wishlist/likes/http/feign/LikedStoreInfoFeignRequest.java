package kr.bb.wishlist.likes.http.feign;

import bloomingblooms.domain.wishlist.likes.LikedStoreInfoResponse;
import bloomingblooms.response.CommonResponse;
import kr.bb.wishlist.likes.dto.message.StoreIdListDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "get-liked-store-info",url = "${service.store.domain}")
public interface LikedStoreInfoFeignRequest {

  @PostMapping("/client/stores/simple-info")
  public CommonResponse<LikedStoreInfoResponse> getLikedStoreInfo(@RequestBody StoreIdListDto storeIdListDto,
      Pageable pageable);


}
