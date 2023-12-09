package kr.bb.wishlist.cart.http.controller.message;

import kr.bb.wishlist.common.valueobject.ProductId;
import org.springframework.stereotype.Component;

@Component
public interface CartItemStockRequest<PID extends ProductId> {
  public int request(PID pid);
}
