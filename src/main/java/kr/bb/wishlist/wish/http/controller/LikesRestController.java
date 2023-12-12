package kr.bb.wishlist.wish.http.controller;

import bloomingblooms.response.CommonResponse;
import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.wish.dto.response.LikedProductInfoResponse;
import kr.bb.wishlist.wish.dto.response.LikedStoreInfoResponse;
import kr.bb.wishlist.wish.http.message.LikedProductInfoRequest;
import kr.bb.wishlist.wish.http.message.LikedStoreInfoRequest;
import kr.bb.wishlist.wish.service.LikesStoreService;
import kr.bb.wishlist.wish.service.LikesProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikesRestController {

  private final LikedStoreInfoRequest storeInfoRequest;
  private final LikedProductInfoRequest productInfoRequest;
  private final LikesStoreService likesStoreService;
  private final LikesProductService likesProductService;


  @GetMapping("/likes/product")
  public CommonResponse<LikedProductInfoResponse> getUserProductLikes(
      @RequestHeader Long userId) {
    LikedProductInfoResponse response = productInfoRequest.request(
        likesProductService.getProductLikes(new UserId(userId)));
    return CommonResponse.success(response);
  }

  @GetMapping("/likes/store")
  public CommonResponse<LikedStoreInfoResponse> getUserStoreLikes(
      @RequestHeader Long userId) {
    LikedStoreInfoResponse response = storeInfoRequest.request(
        likesStoreService.getStoreIdLikes(new UserId(userId)));
    return CommonResponse.success(response);
  }


  @PutMapping("/likes/product")
  public CommonResponse<String> onOffProductLikes(
      @RequestHeader Long userId, @RequestBody List<ProductId> ProductIdList) {
    likesProductService.likesProduct(ProductIdList, new UserId(userId));
    return CommonResponse.success("찜 취소, 혹은 찜 성공");
  }

  @PutMapping("/likes/stores")
  public CommonResponse<String> onOffStoreLikes(
      @RequestHeader Long userId, @RequestBody List<StoreId> storeIdList) {
    likesStoreService.likes(storeIdList, new UserId(userId));
    return CommonResponse.success("찜 취소, 혹은 찜 성공");
  }

}
