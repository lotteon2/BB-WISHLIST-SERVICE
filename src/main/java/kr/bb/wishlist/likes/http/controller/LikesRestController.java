package kr.bb.wishlist.likes.http.controller;

import bloomingblooms.domain.wishlist.likes.LikedProductInfoResponse;
import bloomingblooms.domain.wishlist.likes.LikedStoreInfoResponse;
import bloomingblooms.response.CommonResponse;
import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.http.message.LikedProductInfoRequest;
import kr.bb.wishlist.likes.http.message.LikedStoreInfoRequest;
import kr.bb.wishlist.likes.service.LikesStoreService;
import kr.bb.wishlist.likes.service.LikesProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikesRestController {

  private final LikedStoreInfoRequest<StoreId> storeInfoRequest;
  private final LikedProductInfoRequest<ProductId> productInfoRequest;
  private final LikesStoreService<StoreId> likesStoreService;
  private final LikesProductService<ProductId> likesProductService;


  @GetMapping("/likes/products")
  public CommonResponse<LikedProductInfoResponse> getUserProductLikes(
      @RequestHeader Long userId,
      Pageable pageable) {
    LikedProductInfoResponse response = productInfoRequest.request(
        likesProductService.getProductLikes(new UserId(userId)),pageable);
    return CommonResponse.success(response);
  }

  @GetMapping("/likes/stores")
  public CommonResponse<LikedStoreInfoResponse> getUserStoreLikes(
      @RequestHeader Long userId,Pageable pageable) {
    LikedStoreInfoResponse response = storeInfoRequest.request(
        likesStoreService.getStoreIdLikes(new UserId(userId)),pageable);
    return CommonResponse.success(response);
  }


  @PutMapping("/likes/products")
  public CommonResponse<String> onOffProductLikes(
      @RequestHeader Long userId, @RequestBody List<ProductId> productIdList) {
    likesProductService.likesProduct(productIdList, new UserId(userId));
    return CommonResponse.success("찜 취소, 혹은 찜 성공");
  }

  @PutMapping("/likes/stores")
  public CommonResponse<String> onOffStoreLikes(
      @RequestHeader Long userId, @RequestBody List<StoreId> storeIdList) {
    likesStoreService.likes(storeIdList, new UserId(userId));
    return CommonResponse.success("찜 취소, 혹은 찜 성공");
  }

}
