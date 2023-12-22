package kr.bb.wishlist.cart.http.message;

import java.util.Map;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import kr.bb.wishlist.cart.http.feign.CartItemDetailInfoFeignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class GetCartItemProductInfoMessageRequestImpl implements
    GetCartItemProductInfoMessageRequest {

  private final CartItemDetailInfoFeignRequest feignRequest;
  @Override
  public GetUserCartItemsResponse request(Map<String,Long> productIdWithSelectedQuantity) {
    return feignRequest.getCartItemDetails(productIdWithSelectedQuantity).getData();
  }
}
