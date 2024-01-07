package kr.bb.wishlist.likes.store;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
import kr.bb.wishlist.likes.repository.LikesStoreJpaRepository;
import kr.bb.wishlist.likes.service.ChangeLikedStatusWhenRequestTwice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LikesStoreStrategyTest {

  @InjectMocks
  private ChangeLikedStatusWhenRequestTwice statusChangeWhenRequestTwice;
  @Mock
  private LikesStoreJpaRepository repository;

  @DisplayName("이미 찜을 누른 상태일 경우 찜 취소")
  @Test
  void DoLikes_WhenAlreadyStatusIsLiked_CancelStoreLikes() {

    StoreLikesCompositeKey compositeKey = new StoreLikesCompositeKey(1L, 1L);
    StoreLikesEntity storeLikesEntity = new StoreLikesEntity(compositeKey, true);

    when(repository.findById(any())).thenReturn(Optional.of(storeLikesEntity));

    statusChangeWhenRequestTwice.likes(new StoreId(compositeKey.getStoreId()),
        new UserId(compositeKey.getUserId()));

    ArgumentCaptor<StoreLikesEntity> argumentCaptor = ArgumentCaptor.forClass(
        StoreLikesEntity.class);
    verify(repository, times(1)).save(argumentCaptor.capture());

    StoreLikesEntity savedEntity = argumentCaptor.getValue();

    assertFalse(savedEntity.getIsLiked());


  }

  @DisplayName("찜을 누르지 않은 상태라면 찜 상태로 변경")
  @Test
  void DoLikes_WhenAlreadyStatusIsUNLiked_DoLikes() {
    StoreLikesCompositeKey compositeKey = new StoreLikesCompositeKey(1L, 1L);
    StoreLikesEntity storeLikesEntity = new StoreLikesEntity(compositeKey, false);

    when(repository.findById(any())).thenReturn(Optional.of(storeLikesEntity));

    statusChangeWhenRequestTwice.likes(new StoreId(compositeKey.getStoreId()),
        new UserId(compositeKey.getUserId()));

    ArgumentCaptor<StoreLikesEntity> argumentCaptor = ArgumentCaptor.forClass(
        StoreLikesEntity.class);
    verify(repository, times(1)).save(argumentCaptor.capture());

    StoreLikesEntity savedEntity = argumentCaptor.getValue();

    assertTrue(savedEntity.getIsLiked());


  }
}
