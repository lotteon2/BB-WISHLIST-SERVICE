package kr.bb.wishlist.likes.repository;


import java.util.List;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikesStoreJpaRepository extends
    JpaRepository<StoreLikesEntity, StoreLikesCompositeKey> {

   @Query("SELECT sl FROM StoreLikesEntity sl WHERE sl.storeLikesCompositeKey.userId = :userId and sl.isLiked = true ORDER BY sl.updatedAt DESC")
   List<StoreLikesEntity> findAllByStoreLikesCompositeKey_UserId(Long userId);
}
