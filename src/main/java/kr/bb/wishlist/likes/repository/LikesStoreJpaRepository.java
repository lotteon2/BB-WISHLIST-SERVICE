package kr.bb.wishlist.likes.repository;


import java.util.List;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesStoreJpaRepository extends
    JpaRepository<StoreLikesEntity, StoreLikesCompositeKey> {
   List<StoreLikesEntity> findAllByStoreLikesCompositeKey_UserId(Long userId);
}
