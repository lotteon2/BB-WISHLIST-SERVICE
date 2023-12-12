package kr.bb.wishlist.wish.http.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.wish.dto.response.LikedStoreInfoResponse;
import org.springframework.stereotype.Component;

@Component
public class LikedStoreInfoRequestImpl implements
    LikedStoreInfoRequest {

//  private final StoreInfoRequestByLikesFeign feignRequest;
  @Override
  public LikedStoreInfoResponse request(List<StoreId> storeId) {
    return null;
  }
}
