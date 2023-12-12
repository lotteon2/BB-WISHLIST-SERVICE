package kr.bb.wishlist.wish.repository;


import kr.bb.wishlist.wish.entity.LikesStoreEntity;
import kr.bb.wishlist.wish.entity.StoreLikesCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesStoreJpaRepository extends
    JpaRepository<LikesStoreEntity, StoreLikesCompositeKey> {

}
