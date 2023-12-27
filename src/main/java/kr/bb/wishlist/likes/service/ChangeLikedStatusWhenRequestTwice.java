package kr.bb.wishlist.likes.service;

import java.util.Optional;
import javax.transaction.Transactional;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
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

 @Transactional
  @Override
  public void likes(StoreId storeId, UserId userId) {
    StoreLikesCompositeKey compositeKey = StoreLikesCompKeyMaker.get(userId,storeId );
    Optional<StoreLikesEntity> optionalStoreLikesEntity = repository.findById(compositeKey);

    if (optionalStoreLikesEntity.isPresent()) {
      likesCancel(optionalStoreLikesEntity.get());
    } else {
      repository.save(
          StoreLikesEntity.builder().isLiked(true).storeLikesCompositeKey(compositeKey).build());
    }


  }

  private void likesCancel(StoreLikesEntity storeLikesEntity) {
    repository.save(
        LikesStoreMapper.changeLikesStatus(storeLikesEntity,
            !storeLikesEntity.getIsLiked()));
  }
}
