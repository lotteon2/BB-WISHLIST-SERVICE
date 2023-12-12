package kr.bb.wishlist.wish.repository;

import kr.bb.wishlist.wish.entity.ProductLikesCompositeKey;
import kr.bb.wishlist.wish.entity.ProductLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesProductJpaRepository extends JpaRepository<ProductLikesEntity, ProductLikesCompositeKey> {

}
