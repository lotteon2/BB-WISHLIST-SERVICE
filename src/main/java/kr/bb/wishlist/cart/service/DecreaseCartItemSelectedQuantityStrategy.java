package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.cart.entity.CartEntity;
import org.springframework.stereotype.Service;

@Service
public interface DecreaseCartItemSelectedQuantityStrategy {

  void decreaseCartItemSelectedQuantity(CartEntity cartEntity,
      int updatedDecreasedStock);
}
