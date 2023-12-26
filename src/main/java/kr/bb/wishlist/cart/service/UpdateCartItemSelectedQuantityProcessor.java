package kr.bb.wishlist.cart.service;

import javax.transaction.Transactional;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.exception.CartDomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateCartItemSelectedQuantityProcessor {
  private final IncreaseCartItemSelectedQuantityStrategy increaseCartItemSelectedQuantityStrategy;
  private final DecreaseCartItemSelectedQuantityStrategy decreaseCartItemSelectedQuantityStrategy;

  @Transactional
  public void update(CartEntity cartEntity, Long currentSelectedQuantity,
      Long totalUpdateSelectedQuantity) {
    if (totalUpdateSelectedQuantity < 1) {
      decrease(cartEntity, totalUpdateSelectedQuantity);
    }  else if (totalUpdateSelectedQuantity < currentSelectedQuantity) {
      decrease(cartEntity, totalUpdateSelectedQuantity);
    } else {
      increase(cartEntity, totalUpdateSelectedQuantity);
    }
  }

  private void decrease(CartEntity cartEntity,
      Long totalUpdateSelectedQuantity) {
    decreaseCartItemSelectedQuantityStrategy.decreaseCartItemSelectedQuantity(cartEntity,
        totalUpdateSelectedQuantity);

  }

  private void increase(CartEntity cartEntity,
      Long  totalUpdateSelectedQuantity) {
    increaseCartItemSelectedQuantityStrategy.increase(cartEntity, totalUpdateSelectedQuantity);
  }


}
