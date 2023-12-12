package kr.bb.wishlist.cart.dto.command;

import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeleteCartItemListCommand{
  List<ProductId> productIdList;
}
