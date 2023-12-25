package kr.bb.wishlist.cart.dto.command;

import kr.bb.wishlist.common.valueobject.ProductId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateCartItemCommand<ID extends ProductId> {
  private ID productId;
  private Long selectedQuantitiy ;
}
