package kr.bb.wishlist.cart.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import kr.bb.wishlist.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartEntity extends BaseEntity {
  @EmbeddedId
  private CartCompositeKey cartCompositekey;
  private Long selectedQuantity;
}
