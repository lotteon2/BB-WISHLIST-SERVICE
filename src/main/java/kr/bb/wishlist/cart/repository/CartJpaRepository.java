package kr.bb.wishlist.cart.repository;

import kr.bb.wishlist.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartJpaRepository extends JpaRepository<CartEntity, Long> {

}
