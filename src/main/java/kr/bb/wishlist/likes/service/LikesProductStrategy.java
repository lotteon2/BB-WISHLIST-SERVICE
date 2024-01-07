package kr.bb.wishlist.likes.service;

import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface LikesProductStrategy<ID extends ProductId> {
  public void likes(ID productId, UserId userId);
}
