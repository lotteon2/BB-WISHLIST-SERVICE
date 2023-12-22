package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.mapper.CartMapper;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public abstract class IncreaseStockAsUserRequest implements
    IncreaseCartItemSelectedQuantityStrategy {

  private final CartJpaRepository repository;

  @Override
  public void increase(CartEntity cartEntity, int totalIncreasedUpdatedQuantity) {
    repository.save(CartMapper.getCartEntityWithUpdatedSelectedQuantity(cartEntity,
        totalIncreasedUpdatedQuantity));
  }
}
