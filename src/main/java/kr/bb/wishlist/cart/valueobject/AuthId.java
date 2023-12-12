package kr.bb.wishlist.cart.valueobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@SuperBuilder
@Getter
public class AuthId extends BaseId<Long> {

  public AuthId(Long value) {
    super(value);
  }

}
