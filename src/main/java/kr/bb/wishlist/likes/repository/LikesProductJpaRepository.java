package kr.bb.wishlist.likes.repository;

import java.util.List;
import kr.bb.wishlist.likes.entity.ProductLikesCompositeKey;
import kr.bb.wishlist.likes.entity.ProductLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikesProductJpaRepository extends JpaRepository<ProductLikesEntity, ProductLikesCompositeKey> {

    @Query("SELECT pl FROM ProductLikesEntity pl WHERE pl.likesCompositeKey = :userId ORDER BY pl.updatedAt DESC")
    public List<ProductLikesEntity> findAllByLikesCompositeKey_UserId(Long userId);
}
