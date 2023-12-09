package kr.bb.wishlist.cart.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartItemProductIdList {
  List<Long> productIdList;
}
