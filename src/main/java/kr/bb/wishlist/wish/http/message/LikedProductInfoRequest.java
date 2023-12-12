package kr.bb.wishlist.wish.http.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.wish.dto.response.LikedProductInfoResponse;
import org.springframework.stereotype.Component;

@Component
public interface LikedProductInfoRequest {
  public LikedProductInfoResponse request(List<ProductId>productIdList);
}
