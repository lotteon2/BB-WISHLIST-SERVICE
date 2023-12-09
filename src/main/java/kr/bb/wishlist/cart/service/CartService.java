package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.cart.dto.CartItemProductIdList;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface CartService<ID extends UserId> {
  public CartItemProductIdList getCartItem(ID userId);
}
