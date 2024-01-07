package kr.bb.wishlist.cart.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import kr.bb.wishlist.common.valueobject.ProductId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartItemProductIdDto {
  @NotNull
  List<ProductId> productIdList;
}
