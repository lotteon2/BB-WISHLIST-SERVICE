package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface CartDeleteCartItemStrategy<UID extends UserId, PID extends ProductId> {
  public void delete(UID userId,PID productId);
}
