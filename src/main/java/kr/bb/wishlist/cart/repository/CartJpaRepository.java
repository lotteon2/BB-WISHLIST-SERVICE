package kr.bb.wishlist.cart.repository;

import java.util.List;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartJpaRepository extends JpaRepository<CartEntity, CartCompositeKey> {
    @Query("SELECT c FROM CartEntity c WHERE c.cartCompositekey.userId = :userId ORDER BY c.updatedAt DESC")
    List<CartEntity> findAllByCartCompositekey_UserId(Long userId);
}
