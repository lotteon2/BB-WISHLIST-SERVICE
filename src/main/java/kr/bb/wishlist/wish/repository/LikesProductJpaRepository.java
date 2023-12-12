package kr.bb.wishlist.wish.repository;

import java.util.List;
import kr.bb.wishlist.wish.entity.ProductLikesCompositeKey;
import kr.bb.wishlist.wish.entity.ProductLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesProductJpaRepository extends JpaRepository<ProductLikesEntity, ProductLikesCompositeKey> {
    public List<ProductLikesEntity> findAllByLikesCompositeKey_UserId(Long userId);
}
