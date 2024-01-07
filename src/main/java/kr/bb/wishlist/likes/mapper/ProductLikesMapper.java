package kr.bb.wishlist.likes.mapper;

import kr.bb.wishlist.likes.entity.ProductLikesEntity;

public class ProductLikesMapper {


  public static ProductLikesEntity productLikesWithNewStatus(ProductLikesEntity productLikesEntity, Boolean changedStatus) {
    return ProductLikesEntity.builder().isLiked(changedStatus).likesCompositeKey(productLikesEntity.getLikesCompositeKey()).build();
  }
}
