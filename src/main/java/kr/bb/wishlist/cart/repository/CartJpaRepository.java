package kr.bb.wishlist.cart.repository;

import java.util.List;
import kr.bb.wishlist.cart.entity.CartCompositekey;
import kr.bb.wishlist.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartJpaRepository extends JpaRepository<CartEntity, CartCompositekey> {
    List<CartEntity> findAllByCartCompositekey_UserId(Long userId);


}
