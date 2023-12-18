package kr.bb.wishlist.likes.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import kr.bb.wishlist.cart.repository.ProductIdProjection;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.ProductLikesEntity;
import kr.bb.wishlist.likes.repository.LikesProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesProductServiceImpl implements
    LikesProductService<ProductId> {

  private final LikesProductJpaRepository repository;
  private final LikesProductStrategy<ProductId> strategy;

  @Transactional
  @Override
  public void likesProduct(List<ProductId> productIdList, UserId userId) {
    for (ProductId productId : productIdList) {
      strategy.likes(productId, userId);
    }
  }

  @Override
  public List<ProductId> getProductLikes(UserId userId) {
    List<ProductLikesEntity> productLikesEntityList = repository.findAllByLikesCompositeKey_UserId(
        userId.getValue());

    List<ProductIdProjection> productIdProjectionList = getProjection(productLikesEntityList);

    return productIdProjectionList.stream()
        .map(ProductIdProjection::getProductId).collect(Collectors.toList());
  }


  public List<ProductIdProjection> getProjection(List<ProductLikesEntity> list) {
    return list.stream()
        .map(p -> ProductIdProjection.createFromLong(
                new ProductId(p.getLikesCompositeKey().getProductId())))
            .collect(
                Collectors.toList());
  }
}
