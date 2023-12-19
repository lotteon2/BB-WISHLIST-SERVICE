package kr.bb.wishlist.likes.http.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.likes.dto.response.LikedProductInfoResponse;
import org.springframework.stereotype.Component;

@Component
public interface LikedProductInfoRequest<ID extends ProductId> {
  public LikedProductInfoResponse request(List<ID>productIdList);
}
