package kr.bb.wishlist.likes.http.feign;

import bloomingblooms.response.CommonResponse;
import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.service.LikesProductService;
import kr.bb.wishlist.likes.service.LikesStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikesFeignController {


  private final LikesProductService<ProductId> likesProductService;
  private final LikesStoreService<StoreId> likesStoreService;


  @GetMapping("/client/likes-cnt")
  public CommonResponse<Long> getLikesCntByUserId(@RequestHeader Long userId) {
    UserId userIdObject = new UserId(userId);
    List<ProductId> productIdList = likesProductService.getProductLikes(userIdObject);
    List<StoreId> storeIdList = likesStoreService.getStoreIdLikes(userIdObject);
    Long cntNumber = (long) (productIdList.size() + storeIdList.size());
    return CommonResponse.success(cntNumber);
  }

}
