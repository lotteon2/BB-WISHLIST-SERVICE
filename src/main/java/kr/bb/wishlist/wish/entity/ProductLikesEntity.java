package kr.bb.wishlist.wish.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class ProductLikesEntity {
  @EmbeddedId
  private ProductLikesCompositeKey likesCompositeKey;
  private Boolean isLiked;
}
