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
  public void update(CartEntity cartEntity, int currentSelectedQuantity,
      int totalUpdateSelectedQuantity) {
    if (totalUpdateSelectedQuantity < 1) {
      throw new CartDomainException("1개 이하로는 수량을 조절할 수 없습니다.");
    }  else if (totalUpdateSelectedQuantity < currentSelectedQuantity) {
      decrease(cartEntity, totalUpdateSelectedQuantity);
    } else {
      increase(cartEntity, totalUpdateSelectedQuantity);
    }
  }

  private void decrease(CartEntity cartEntity,
      int totalUpdateSelectedQuantity) {
    decreaseCartItemSelectedQuantityStrategy.decreaseCartItemSelectedQuantity(cartEntity,
        totalUpdateSelectedQuantity);

  }

  private void increase(CartEntity cartEntity,
      int totalUpdateSelectedQuantity) {
    increaseCartItemSelectedQuantityStrategy.increase(cartEntity, totalUpdateSelectedQuantity);
  }


}
