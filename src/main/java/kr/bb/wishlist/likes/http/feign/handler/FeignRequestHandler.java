package kr.bb.wishlist.likes.http.feign.handler;

import bloomingblooms.response.CommonResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import kr.bb.wishlist.common.valueobject.BaseId;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.service.LikesProductService;
import kr.bb.wishlist.likes.service.LikesStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeignRequestHandler<UID extends UserId, PID extends ProductId, SID extends StoreId> {

  private final LikesProductService<PID> likesProductService;
  private final LikesStoreService<SID> likesStoreService;

  public Long getUserLikesCnt(UID userId) {
    List<PID> productIdList = likesProductService.getProductLikes(userId);
    List<SID> storeIdList = likesStoreService.getStoreIdLikes(userId);
    return (long) (productIdList.size() + storeIdList.size());
  }

  public List<String> getUserLikesProductListByUserIdAndProductList(
      List<String> inputProductList,
      UserId userId) {
    List<PID> productIdList = likesProductService.getProductLikes(userId);

    return productIdList.stream()
        .filter(inputProductList::contains).map(BaseId::getValue)
        .collect(Collectors.toList());

  }

  public Boolean isUserLikedThisProduct(PID productId, UID userId) {
    List<PID> productIdList = likesProductService.getProductLikes(userId);
    return productIdList.stream().anyMatch(p -> p.equals(productId));
  }

  public Map<Long, Boolean> getUserLikesInputStoreIdList(List<SID> storeIdList, UID userId) {
    List<SID> storeIdListByUser = likesStoreService.getStoreIdLikes(userId);

    return storeIdList.stream()
        .collect(Collectors.toMap(
            BaseId::getValue,
            storeIdListByUser::contains
        ));
  }

}
