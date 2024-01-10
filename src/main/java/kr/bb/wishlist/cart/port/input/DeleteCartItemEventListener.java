package kr.bb.wishlist.cart.port.input;

import java.util.Map;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public interface DeleteCartItemEventListener {
  public void delete(Map<Long, String> value);
}
