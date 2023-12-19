package kr.bb.wishlist.likes.http.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.likes.dto.response.LikedStoreInfoResponse;
import org.springframework.stereotype.Component;

@Component
public interface LikedStoreInfoRequest<ID extends StoreId> {
  public LikedStoreInfoResponse request(List<ID> storeId);
}
