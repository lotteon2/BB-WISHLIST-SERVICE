package kr.bb.wishlist.likes.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
import kr.bb.wishlist.likes.repository.LikesStoreJpaRepository;
import kr.bb.wishlist.likes.util.StoreIdProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikesStoreServiceImpl implements
    LikesStoreService<StoreId> {

  private final StoreLikesStrategy<StoreId> likesStrategy;
  private final LikesStoreJpaRepository repository;

  @Transactional
  @Override
  public void likes(List<StoreId> storeIdList, UserId userId) {
    for (StoreId storeId : storeIdList) {
      likesStrategy.likes(storeId, userId);
    }
  }

  @Override
  public List<StoreId> getStoreIdLikes(UserId userId) {

    List<StoreLikesEntity> storeLikesEntityList = repository.findAllByStoreLikesCompositeKey_UserId(
        userId.getValue());

    List<StoreIdProjection> projections = getStoreIdProjection(storeLikesEntityList);

    return projections.stream()
        .map(StoreIdProjection::getStoreId)
        .collect(Collectors.toList());

  }

  private List<StoreIdProjection> getStoreIdProjection(List<StoreLikesEntity> list) {
    return list.stream().map(
        s -> StoreIdProjection.createStoreId(new StoreId(s.getStoreLikesCompositeKey().getStoreId())
        )
    ).collect(Collectors.toList());
  }
}
