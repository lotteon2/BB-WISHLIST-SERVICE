package kr.bb.wishlist.cart.http.message;

import kr.bb.wishlist.cart.dto.CartItemProductIdDto;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import org.springframework.stereotype.Component;

@Component
public interface GetCartItemProductInfoMessageRequest {

  public GetUserCartItemsResponse request(CartItemProductIdDto idList);
}
