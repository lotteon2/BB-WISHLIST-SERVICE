package kr.bb.wishlist.likes.service;

import java.util.Optional;
import javax.transaction.Transactional;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.ProductLikesCompositeKey;
import kr.bb.wishlist.likes.entity.ProductLikesEntity;
import kr.bb.wishlist.likes.mapper.ProductLikesMapper;
import kr.bb.wishlist.likes.repository.LikesProductJpaRepository;
import kr.bb.wishlist.likes.util.ProductLikesCompKeyMaker;
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
    ProductLikesCompositeKey compositeKey = ProductLikesCompKeyMaker.get(productId, userId);
    Optional<ProductLikesEntity> optionalProductLikesEntity = repository.findById(compositeKey);

    if (optionalProductLikesEntity.isPresent()) {
      likesCancel(optionalProductLikesEntity.get());
    } else {
      repository.save(
          ProductLikesEntity.builder().isLiked(true).likesCompositeKey(compositeKey).build());
    }


  }

  private void likesCancel(ProductLikesEntity productLikesEntity) {
    repository.save(
        ProductLikesMapper.productLikesWithNewStatus(productLikesEntity,
            !productLikesEntity.getIsLiked()));
  }
}
