package kr.bb.wishlist.common.valueobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@SuperBuilder
@Getter
public class UserId extends BaseId<Long> {
  public UserId(Long value) {
    super(value);
  }

}
