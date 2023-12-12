package kr.bb.wishlist.wish.http.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.wish.dto.response.LikedStoreInfoResponse;
import kr.bb.wishlist.wish.http.feign.LikedStoreInfoFeignRequest;
import org.springframework.stereotype.Component;

@Component
public class LikedStoreInfoRequestImpl implements
    LikedStoreInfoRequest {

  private final LikedStoreInfoFeignRequest feignRequest;
  @Override
  public LikedStoreInfoResponse request(List<Long> storeId) {
    return null;
  }
}
