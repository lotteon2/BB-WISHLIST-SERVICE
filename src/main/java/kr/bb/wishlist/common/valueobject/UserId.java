package kr.bb.wishlist.common.valueobject;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class UserId extends BaseId<Long> {

  public UserId(Long value) {
    super(value);
  }
}
