package kr.bb.wishlist.wish.entity;

import javax.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class LikesEntity {
  @EmbeddedId
  private ProductLikesCompositeKey likesCompositeKey;
  private Boolean isLiked;
}
