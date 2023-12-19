package kr.bb.wishlist.likes.http.feign;

import kr.bb.wishlist.likes.dto.message.StoreIdListDto;
import kr.bb.wishlist.likes.dto.response.LikedStoreInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "get-liked-store-info",url = "${service.store.domain}")
public interface LikedStoreInfoFeignRequest {

  @GetMapping("/stores/likes")
  public ResponseEntity<LikedStoreInfoResponse> getLikedStoreInfo(@RequestBody StoreIdListDto storeIdListDto);


}
