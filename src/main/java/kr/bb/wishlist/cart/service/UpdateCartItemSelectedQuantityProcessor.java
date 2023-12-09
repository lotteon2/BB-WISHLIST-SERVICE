package kr.bb.wishlist.cart.service;

import javax.transaction.Transactional;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.exception.CartDomainException;
import kr.bb.wishlist.cart.mapper.CartMapper;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateCartItemSelectedQuantityProcessor {

  private final CartJpaRepository repository;
  private final IncreaseCartItemSelectedQuantityStrategy increaseCartItemSelectedQuantityStrategy;
  private final DecreaseCartItemSelectedQuantityStrategy decreaseCartItemSelectedQuantityStrategy;

  @Transactional
  public void update(CartEntity cartEntity, int currentSelectedQuantity,
      int totalUpdateSelectedQuantity, int stock) {
    if (totalUpdateSelectedQuantity < 1) {
      throw new CartDomainException("1개 이하로는 수량을 조절할 수 없습니다.");
    } else if (totalUpdateSelectedQuantity <= stock) {
      updateAsStockWhenStockIsNotEfficient(cartEntity, stock);
    } else if (totalUpdateSelectedQuantity < currentSelectedQuantity) {
      decrease(cartEntity, totalUpdateSelectedQuantity, stock);
    } else {
      increase(cartEntity, totalUpdateSelectedQuantity, stock);
    }
  }

  private void decrease(CartEntity cartEntity,
      int totalUpdateSelectedQuantity, int stock) {
    decreaseCartItemSelectedQuantityStrategy.decreaseCartItemSelectedQuantity(cartEntity,
        totalUpdateSelectedQuantity, stock);

  }

  private void increase(CartEntity cartEntity,
      int totalUpdateSelectedQuantity, int stock) {
    increaseCartItemSelectedQuantityStrategy.increase(cartEntity, totalUpdateSelectedQuantity,
        stock);
  }

  private void updateAsStockWhenStockIsNotEfficient(CartEntity cartEntity, int stock) {
    repository.save(CartMapper.getCartEntityWithUpdatedSelectedQuantity(cartEntity, stock));
  }

}
