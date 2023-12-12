package kr.bb.wishlist.common.valueobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
public class ProductId extends BaseId<Long> {
  public ProductId(Long value) {
    super(value);
  }
}
