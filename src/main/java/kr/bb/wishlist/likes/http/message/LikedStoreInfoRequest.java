package kr.bb.wishlist.likes.http.message;

import bloomingblooms.domain.wishlist.likes.LikedStoreInfoResponse;
import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface LikedStoreInfoRequest<ID extends StoreId> {
  public LikedStoreInfoResponse request(List<ID> storeId, Pageable pageable);
}
