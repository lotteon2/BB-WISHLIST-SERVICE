package kr.bb.wishlist.cart.repository;

import java.util.List;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartJpaRepository extends JpaRepository<CartEntity, CartCompositeKey> {
    List<CartEntity> findAllByCartCompositekey_UserId(Long userId);


}
