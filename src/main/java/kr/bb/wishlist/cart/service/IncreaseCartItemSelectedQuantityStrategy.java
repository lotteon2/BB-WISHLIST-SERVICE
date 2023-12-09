package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.cart.entity.CartEntity;
import org.springframework.stereotype.Service;

@Service
public interface IncreaseCartItemSelectedQuantityStrategy {
  public void increase(CartEntity cartEntity, int totalIncreasedUpdatedQuantity, int stock);
}
