package kr.bb.wishlist.wish.mapper;

import kr.bb.wishlist.wish.entity.LikesStoreEntity;

public class LikesStoreMapper {


  public static LikesStoreEntity changeLikesStatus(LikesStoreEntity likesStoreEntity,
      Boolean status) {
    return LikesStoreEntity.builder()
        .storeLikesCompositeKey(likesStoreEntity.getStoreLikesCompositeKey()).isLiked(status)
        .build();
  }


}
