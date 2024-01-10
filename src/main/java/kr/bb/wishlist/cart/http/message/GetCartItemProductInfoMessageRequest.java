package kr.bb.wishlist.cart.http.message;

import bloomingblooms.domain.wishlist.cart.GetUserCartItemsResponse;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public interface GetCartItemProductInfoMessageRequest {
  public GetUserCartItemsResponse request(Map<String,Long> productIdWithSelectedQuantity);
}
