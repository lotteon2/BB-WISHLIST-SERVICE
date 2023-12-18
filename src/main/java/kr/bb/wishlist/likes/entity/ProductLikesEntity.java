package kr.bb.wishlist.likes.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import kr.bb.wishlist.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class ProductLikesEntity extends BaseEntity {
  @EmbeddedId
  private ProductLikesCompositeKey likesCompositeKey;
  private Boolean isLiked;
}
