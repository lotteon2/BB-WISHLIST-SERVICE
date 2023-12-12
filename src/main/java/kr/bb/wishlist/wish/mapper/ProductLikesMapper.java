package kr.bb.wishlist.wish.mapper;

import kr.bb.wishlist.wish.entity.ProductLikesEntity;

public class ProductLikesMapper {


  public static ProductLikesEntity productLikesWithNewStatus(ProductLikesEntity productLikesEntity, Boolean changedStatus) {
    return ProductLikesEntity.builder().isLiked(changedStatus).likesCompositeKey(productLikesEntity.getLikesCompositeKey()).build();
  }
}
