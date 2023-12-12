package kr.bb.wishlist.wish.http.message;

import java.util.List;
import kr.bb.wishlist.wish.dto.response.LikedStoreInfoResponse;
import org.springframework.stereotype.Component;

@Component
public interface LikedStoreInfoRequest {
  public LikedStoreInfoResponse request(List<Long> storeId);
}
