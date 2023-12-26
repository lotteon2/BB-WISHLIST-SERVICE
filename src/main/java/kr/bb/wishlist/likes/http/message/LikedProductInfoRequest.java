package kr.bb.wishlist.likes.http.message;

import bloomingblooms.domain.wishlist.likes.LikedProductInfoResponse;
import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface LikedProductInfoRequest<ID extends ProductId> {
  public LikedProductInfoResponse request(List<ID>productIdList, Pageable pageable);
}
