package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.exception.CartDomainException;
import kr.bb.wishlist.cart.mapper.CartMapper;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteWhenRequestUpdatedQuantityUnder0 implements
    DecreaseCartItemSelectedQuantityStrategy {

  private final CartJpaRepository repository;
  @Override
  public void decreaseCartItemSelectedQuantity(CartEntity cartEntity,
      Long updatedDecreasedStock) {
    if (updatedDecreasedStock <= 0) {
      repository.delete(cartEntity);
    } else {
      repository.save(
          CartMapper.getCartEntityWithUpdatedSelectedQuantity(cartEntity, updatedDecreasedStock));
    }

  }
}
