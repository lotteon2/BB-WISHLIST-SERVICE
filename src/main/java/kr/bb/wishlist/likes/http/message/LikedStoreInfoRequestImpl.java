package kr.bb.wishlist.likes.http.message;

import bloomingblooms.domain.wishlist.likes.LikedStoreInfoResponse;
import java.util.List;
import java.util.stream.Collectors;
import kr.bb.wishlist.common.valueobject.BaseId;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.likes.http.feign.LikedStoreInfoFeignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikedStoreInfoRequestImpl implements
    LikedStoreInfoRequest<StoreId> {

  private final LikedStoreInfoFeignRequest feignRequest;
  @Override
  public List<LikedStoreInfoResponse> request(List<StoreId> storeIdList) {
    return feignRequest.getLikedStoreInfo(convertLongType(storeIdList)).getData();
  }

  private List<Long> convertLongType(List<StoreId> storeIdList){
    return storeIdList.stream().map(BaseId::getValue).collect(Collectors.toList());
  }

}
