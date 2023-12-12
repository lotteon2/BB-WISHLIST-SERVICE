package kr.bb.wishlist.wish.service;

import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.wish.entity.LikesStoreEntity;
import kr.bb.wishlist.wish.entity.StoreLikesCompositeKey;
import kr.bb.wishlist.wish.exception.LikesDomainException;
import kr.bb.wishlist.wish.mapper.LikesStoreMapper;
import kr.bb.wishlist.wish.repository.LikesStoreJpaRepository;
import kr.bb.wishlist.wish.util.StoreLikesCompKeyMaker;
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

    LikesStoreEntity likesStoreEntity = getLikesStoreEntity(compositeKey);
    Boolean changedStatus = !likesStoreEntity.getIsLiked();

    repository.save(
        LikesStoreMapper.changeLikesStatus(likesStoreEntity, changedStatus));
  }

  private LikesStoreEntity getLikesStoreEntity(StoreLikesCompositeKey compositeKey) {
    return repository.findById(compositeKey).orElseThrow(() -> {
      throw new LikesDomainException("존재하지 않는 가게 찜입니다.");
    });
  }
}
