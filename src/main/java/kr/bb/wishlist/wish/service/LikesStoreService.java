package kr.bb.wishlist.wish.service;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface LikesStoreService {
  public void likes(List<StoreId> storeId, UserId userId);
  public List<StoreId> getStoreIdLikes(UserId useId);
}
