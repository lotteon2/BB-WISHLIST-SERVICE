package kr.bb.wishlist.wish.service;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikesStoreServiceImpl implements
    LikesStoreService {


  @Override
  public void likes(List<StoreId> storeId, UserId userId) {

  }

  @Override
  public List<StoreId> getStoreIdLikes(UserId useId) {
    return null;
  }
}
