package kr.bb.wishlist.likes.http.feign;

import bloomingblooms.response.CommonResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import kr.bb.wishlist.common.valueobject.BaseId;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.http.feign.handler.FeignRequestHandler;
import kr.bb.wishlist.likes.service.LikesProductService;
import kr.bb.wishlist.likes.service.LikesStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikesFeignController {


  private final FeignRequestHandler<UserId, ProductId, StoreId> feignRequestHandler;


  @GetMapping("/client/likes-cnt")
  public CommonResponse<Long> getLikesCntByUserId(@RequestHeader Long userId) {
    return CommonResponse.success(feignRequestHandler.getUserLikesCnt(new UserId(userId)));
  }

  @PostMapping("/client/likes/{userId}")
  public CommonResponse<List<String>> getProductLikesByUser(@PathVariable Long userId,
      @RequestBody List<String> productIdList) {
    return CommonResponse.success(
        feignRequestHandler.getUserLikesProductListByUserIdAndProductList(productIdList,
            new UserId(userId)));
  }

  @GetMapping("/client/likes/{userId}/product/{productId}")
  public CommonResponse<Boolean> checkProductIsLiked(@PathVariable Long userId,
      @PathVariable String productId) {
    return CommonResponse.success(
        feignRequestHandler.isUserLikedThisProduct(new ProductId(productId), new UserId(userId)));

  }

  @GetMapping("/client/likes/stores")
  public CommonResponse<Map<Long, Boolean>> getBooleanByUserIdWithStoreLikesInput(
      @RequestHeader Long userId, @RequestBody List<Long> storeIds) {
    return CommonResponse.success(feignRequestHandler.getUserLikesInputStoreIdList(storeIds.stream()
        .map(StoreId::new)
        .collect(Collectors.toList()), new UserId(userId)));
  }


}
