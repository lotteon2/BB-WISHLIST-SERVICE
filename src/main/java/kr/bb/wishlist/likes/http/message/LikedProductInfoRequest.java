package kr.bb.wishlist.likes.http.message;

import bloomingblooms.domain.wishlist.likes.LikedProductInfoResponse;
import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import org.springframework.stereotype.Component;

@Component
public interface LikedProductInfoRequest<ID extends ProductId> {
  public List<LikedProductInfoResponse> request(List<ID>productIdList);
}
