package kr.bb.wishlist.cart.dto.response;

import java.util.List;
import kr.bb.wishlist.cart.dto.CartProductItemInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class GetUserCartItemsResponse {
  List<CartProductItemInfo> cartProductItemInfoList;

}
