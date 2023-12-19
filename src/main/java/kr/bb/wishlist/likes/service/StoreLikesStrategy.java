package kr.bb.wishlist.likes.service;

import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface StoreLikesStrategy<ID extends StoreId> {
  public void likes(ID storeId, UserId userId);
}
