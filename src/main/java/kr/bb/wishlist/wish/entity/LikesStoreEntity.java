package kr.bb.wishlist.wish.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.ws.rs.GET;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class LikesStoreEntity {

  @EmbeddedId
  private StoreLikesCompositeKey storeLikesCompositeKey;
  private Boolean isLiked;

}
