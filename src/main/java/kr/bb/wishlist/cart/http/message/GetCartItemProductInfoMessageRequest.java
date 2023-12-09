package kr.bb.wishlist.cart.http.message;

import kr.bb.wishlist.cart.dto.CartItemProductIdList;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import org.springframework.stereotype.Component;

@Component
public interface GetCartItemProductInfoMessageRequest {

  public GetUserCartItemsResponse request(CartItemProductIdList idList);
}
