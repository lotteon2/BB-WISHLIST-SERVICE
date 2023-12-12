package kr.bb.wishlist.wish.service;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface LikesStoreService<ID extends StoreId> {
  public void likes(List<ID> storeId, UserId userId);
  public List<ID> getStoreIdLikes(UserId userId);
}
