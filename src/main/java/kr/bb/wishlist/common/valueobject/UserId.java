package kr.bb.wishlist.common.valueobject;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserId extends BaseId<Long> {

  public UserId(Long value) {
    super(value);
  }
}
