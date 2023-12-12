package kr.bb.wishlist.wish.service;

import javax.transaction.Transactional;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.wish.entity.ProductLikesCompositeKey;
import kr.bb.wishlist.wish.entity.ProductLikesEntity;
import kr.bb.wishlist.wish.exception.LikesDomainException;
import kr.bb.wishlist.wish.mapper.ProductLikesMapper;
import kr.bb.wishlist.wish.repository.LikesProductJpaRepository;
import kr.bb.wishlist.wish.util.ProductLikesCompKeyMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductLikesOnOffWhenRequestTwice implements
    LikesProductStrategy<ProductId> {

  private final LikesProductJpaRepository repository;

  @Transactional
  @Override
  public void likes(ProductId productId, UserId userId) {
    ProductLikesEntity productLikesEntity = getProductLikesEntity(
        ProductLikesCompKeyMaker.get(productId, userId));

    Boolean changedStatus = !productLikesEntity.getIsLiked();

    repository.save(
        ProductLikesMapper.productLikesWithNewStatus(productLikesEntity, changedStatus));
  }

  private ProductLikesEntity getProductLikesEntity(
      ProductLikesCompositeKey productLikesCompositeKey) {
    return repository.findById(productLikesCompositeKey).orElseThrow(()->{
      throw new LikesDomainException("존재하지 않는 상품 찜입니다.");
    });
  }
}
