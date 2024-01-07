package kr.bb.wishlist.likes.store;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
import kr.bb.wishlist.likes.repository.LikesStoreJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
 class StoreLikesJpaRepositoryTest {

  @Autowired
  private LikesStoreJpaRepository repository;


  @Test
  void GetDESCArrangedTime_WhenStoreLikesIsOver2_GetArrangedWithDESC() {
      Long userId = 1L;
        Long firstStoreId = 1L;
        Long secondStoreId = 2L;

        StoreLikesEntity likes1 = StoreLikesEntity.builder()
                .storeLikesCompositeKey(new StoreLikesCompositeKey(userId, firstStoreId))
                .isLiked(true)
                .build();

        StoreLikesEntity likes2 = StoreLikesEntity.builder()
                .storeLikesCompositeKey(new StoreLikesCompositeKey(userId, secondStoreId))
                .isLiked(true)
                .build();

        repository.save(likes1);
        repository.save(likes2);

        List<StoreLikesEntity> likesEntities = repository.findAllByStoreLikesCompositeKey_UserId(userId);

        assertTrue(likesEntities != null && !likesEntities.isEmpty());

        assertTrue(
                likesEntities.get(0).getUpdatedAt().compareTo(likesEntities.get(1).getUpdatedAt()) > 0);
    }
}
