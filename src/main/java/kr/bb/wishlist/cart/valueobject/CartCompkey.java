package kr.bb.wishlist.cart.valueobject;

import kr.bb.wishlist.common.valueobject.CompkeyId;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Getter
public class CartCompkey extends CompkeyId<UserId, ProductId> {


}
