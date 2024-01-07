package kr.bb.wishlist.likes.http.controller;

import bloomingblooms.domain.wishlist.likes.LikedProductInfoResponse;
import bloomingblooms.domain.wishlist.likes.LikedStoreInfoResponse;
import bloomingblooms.response.CommonResponse;
import java.util.Collections;
import java.util.List;
import kr.bb.wishlist.common.util.PaginationUtil;
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
  public CommonResponse<List<LikedProductInfoResponse>> getUserProductLikes(
      @RequestHeader Long userId, Pageable pageable) {

    List<ProductId> productIdList = likesProductService.getProductLikes(new UserId(userId));

    int limitStart = PaginationUtil.calculateLimitStart(pageable);
    int limitEnd = PaginationUtil.calculateLimitEnd(pageable, productIdList.size());

    List<LikedProductInfoResponse> response = fetchLikedProductsInfo(productIdList, limitStart,limitEnd);

    return CommonResponse.success(response);
  }

    private List<LikedProductInfoResponse> fetchLikedProductsInfo(List<ProductId> productIdList,
      int limitStart,int limitEnd) {
    if (!isValidSublistRequest(productIdList, limitStart, limitEnd)) {
      return Collections.emptyList();
    }
    return productInfoRequest.request(productIdList);
  }

  @GetMapping("/likes/stores")
  public CommonResponse<List<LikedStoreInfoResponse>> getUserStoreLikes(
      @RequestHeader Long userId, Pageable pageable) {

    List<StoreId> storeIdList = likesStoreService.getStoreIdLikes(new UserId(userId));
    int limitStart = PaginationUtil.calculateLimitStart(pageable);
    int limitEnd = PaginationUtil.calculateLimitEnd(pageable, storeIdList.size());

    List<LikedStoreInfoResponse> response = fetchLikedStores(storeIdList, limitStart, limitEnd);

    return CommonResponse.success(response);
  }

  private List<LikedStoreInfoResponse> fetchLikedStores(List<StoreId> storeIdList, int limitStart,
      int limitEnd) {
    if (!isValidSublistRequest(storeIdList, limitStart, limitEnd)) {
      return Collections.emptyList();
    }

    return storeInfoRequest.request(storeIdList.subList(limitStart, limitEnd));
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

  private boolean isValidSublistRequest(List<?> list, int limitStart, int limitEnd) {
    return limitStart >= 0 && limitStart < limitEnd && limitEnd <= list.size();
  }
}
