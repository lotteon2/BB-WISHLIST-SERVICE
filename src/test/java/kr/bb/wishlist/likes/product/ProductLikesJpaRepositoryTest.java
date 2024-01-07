package kr.bb.wishlist.likes.product;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.likes.entity.ProductLikesCompositeKey;
import kr.bb.wishlist.likes.entity.ProductLikesEntity;
import kr.bb.wishlist.likes.repository.LikesProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
 class ProductLikesJpaRepositoryTest {
   @Autowired
  private LikesProductJpaRepository repository;

   @Test
  void GetDESCArrangedTime_WhenProductLikesIsOver2_GetArrangedWithDESC() {
        Long userId = 1L;
        String firstProduct = "1";
        String secondProduct = "2";

        ProductLikesEntity likes1 = ProductLikesEntity.builder()
                .likesCompositeKey(new ProductLikesCompositeKey(userId, firstProduct))
                .isLiked(true)
                .build();

        ProductLikesEntity likes2 = ProductLikesEntity.builder()
                .likesCompositeKey(new ProductLikesCompositeKey(userId, secondProduct))
                .isLiked(true)
                .build();

        repository.save(likes1);
        repository.save(likes2);

        List<ProductLikesEntity> likesEntities = repository.findAllByLikesCompositeKey_UserIdAndAndIsLikedTrue(userId);

        assertTrue(likesEntities != null && !likesEntities.isEmpty());

        assertTrue(
                likesEntities.get(0).getUpdatedAt().compareTo(likesEntities.get(1).getUpdatedAt()) > 0);
    }
  }


