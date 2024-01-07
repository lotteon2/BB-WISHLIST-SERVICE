package kr.bb.wishlist.likes.product;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.ProductLikesCompositeKey;
import kr.bb.wishlist.likes.entity.ProductLikesEntity;
import kr.bb.wishlist.likes.repository.LikesProductJpaRepository;
import kr.bb.wishlist.likes.service.ProductLikesOnOffWhenRequestTwice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class LikesProductStrategyTest {

  @InjectMocks
  private ProductLikesOnOffWhenRequestTwice strategy;
  @Mock
  private LikesProductJpaRepository repository;

  @DisplayName("이미 찜을 누른 상태일 경우 찜 취소")
  @Test
  void DoLikes_WhenAlreadyStatusIsLiked_CancelStoreLikes() {

    ProductLikesCompositeKey compositeKey = new ProductLikesCompositeKey(1L, "1");
    ProductLikesEntity storeLikesEntity = new ProductLikesEntity(compositeKey, true);

    when(repository.findById(any())).thenReturn(Optional.of(storeLikesEntity));

    strategy.likes(new ProductId(compositeKey.getProductId()),
        new UserId(compositeKey.getUserId()));

    ArgumentCaptor<ProductLikesEntity> argumentCaptor = ArgumentCaptor.forClass(
        ProductLikesEntity.class);
    verify(repository, times(1)).save(argumentCaptor.capture());

    ProductLikesEntity savedEntity = argumentCaptor.getValue();

    assertFalse(savedEntity.getIsLiked());


  }

  @DisplayName("찜을 누르지 않은 상태라면 찜 상태로 변경")
  @Test
  void DoLikes_WhenAlreadyStatusIsUNLiked_DoLikes() {
    ProductLikesCompositeKey compositeKey = new ProductLikesCompositeKey(1L, "1");
    ProductLikesEntity storeLikesEntity = new ProductLikesEntity(compositeKey, false);

    when(repository.findById(any())).thenReturn(Optional.of(storeLikesEntity));

    strategy.likes(new ProductId(compositeKey.getProductId()),
        new UserId(compositeKey.getUserId()));

    ArgumentCaptor<ProductLikesEntity> argumentCaptor = ArgumentCaptor.forClass(
        ProductLikesEntity.class);
    verify(repository, times(1)).save(argumentCaptor.capture());

    ProductLikesEntity savedEntity = argumentCaptor.getValue();

    assertTrue(savedEntity.getIsLiked());


  }

}
