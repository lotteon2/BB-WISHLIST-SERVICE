package kr.bb.wishlist.likes.service;

import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;
import kr.bb.wishlist.likes.exception.LikesDomainException;
import kr.bb.wishlist.likes.mapper.LikesStoreMapper;
import kr.bb.wishlist.likes.repository.LikesStoreJpaRepository;
import kr.bb.wishlist.likes.util.StoreLikesCompKeyMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChangeLikedStatusWhenRequestTwice implements
    StoreLikesStrategy<StoreId> {

  private final LikesStoreJpaRepository repository;

  @Override
  public void likes(StoreId storeId, UserId userId) {
    StoreLikesCompositeKey compositeKey = StoreLikesCompKeyMaker.get(userId, storeId);

    StoreLikesEntity storeLikesEntity = getLikesStoreEntity(compositeKey);
    Boolean changedStatus = !storeLikesEntity.getIsLiked();

    repository.save(
        LikesStoreMapper.changeLikesStatus(storeLikesEntity, changedStatus));
  }

  private StoreLikesEntity getLikesStoreEntity(StoreLikesCompositeKey compositeKey) {
    return repository.findById(compositeKey).orElseThrow(() -> {
      throw new LikesDomainException("존재하지 않는 가게 찜입니다.");
    });
  }
}
