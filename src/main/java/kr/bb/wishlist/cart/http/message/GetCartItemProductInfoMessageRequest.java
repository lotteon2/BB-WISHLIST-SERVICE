package kr.bb.wishlist.cart.http.message;

import java.util.Map;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import org.springframework.stereotype.Component;

@Component
public interface GetCartItemProductInfoMessageRequest {
  public GetUserCartItemsResponse request(Map<String,Integer> productIdWithSelectedQuantity);
}
