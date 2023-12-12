package kr.bb.wishlist.wish.http.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.wish.dto.response.LikedStoreInfoResponse;
import org.springframework.stereotype.Component;

@Component
public interface LikedStoreInfoRequest<ID extends StoreId> {
  public LikedStoreInfoResponse request(List<ID> storeId);
}
