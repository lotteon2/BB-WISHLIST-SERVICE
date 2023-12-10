package kr.bb.wishlist.cart.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class CartCompositeKey implements Serializable {

  private static final long serialVersionUID = -189479558090736427L;
  private Long userId;
  private Long productId;

}
