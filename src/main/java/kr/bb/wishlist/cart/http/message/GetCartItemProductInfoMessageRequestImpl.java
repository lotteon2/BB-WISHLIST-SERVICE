package kr.bb.wishlist.cart.http.message;

import kr.bb.wishlist.cart.dto.CartItemProductIdDto;
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
  public GetUserCartItemsResponse request(CartItemProductIdDto idList) {
    return feignRequest.getCartItemDetails(idList).getBody();
  }
}
