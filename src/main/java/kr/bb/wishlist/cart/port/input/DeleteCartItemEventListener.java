package kr.bb.wishlist.cart.port.input;

import bloomingblooms.dto.command.CartDeleteCommand;
import org.springframework.stereotype.Component;

@Component
public interface DeleteCartItemEventListener {
  public void delete(CartDeleteCommand command);
}
