package kr.bb.wishlist.wish.http.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.wish.dto.message.StoreIdListDto;
import kr.bb.wishlist.wish.dto.response.LikedStoreInfoResponse;
import kr.bb.wishlist.wish.http.feign.LikedStoreInfoFeignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikedStoreInfoRequestImpl implements
    LikedStoreInfoRequest<StoreId> {

  private final LikedStoreInfoFeignRequest feignRequest;
  @Override
  public LikedStoreInfoResponse request(List<StoreId> storeIdList) {
    return feignRequest.getLikedStoreInfo(new StoreIdListDto(storeIdList)).getBody();
  }
}
