package kr.bb.wishlist.cart.port.input;

import java.util.HashMap;
import java.util.Map;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public interface DeleteCartItemEventListener<UID extends UserId, PID extends ProductId> {
  public void delete(Map<UID, PID> value);
}
