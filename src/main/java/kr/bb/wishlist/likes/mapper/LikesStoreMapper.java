package kr.bb.wishlist.likes.mapper;

import kr.bb.wishlist.likes.entity.StoreLikesEntity;

public class LikesStoreMapper {

  public static StoreLikesEntity changeLikesStatus(StoreLikesEntity storeLikesEntity,
      Boolean status) {
    return StoreLikesEntity.builder()
        .storeLikesCompositeKey(storeLikesEntity.getStoreLikesCompositeKey()).isLiked(status)
        .build();
  }


}
