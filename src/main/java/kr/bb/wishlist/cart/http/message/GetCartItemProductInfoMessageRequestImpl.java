package kr.bb.wishlist.cart.http.message;

import kr.bb.wishlist.cart.dto.CartItemProductIdList;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import kr.bb.wishlist.cart.http.feign.CartItemDetailInfoFeignRequest;
import kr.bb.wishlist.cart.http.message.GetCartItemProductInfoMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class GetCartItemProductInfoMessageRequestImpl implements
    GetCartItemProductInfoMessageRequest {

  private final CartItemDetailInfoFeignRequest feignRequest;
  @Override
  public GetUserCartItemsResponse request(CartItemProductIdList idList) {
    return feignRequest.getCartItemDetails(idList).getBody();
  }
}
