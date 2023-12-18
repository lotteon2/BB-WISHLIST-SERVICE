package kr.bb.wishlist.likes.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import kr.bb.wishlist.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class StoreLikesEntity extends BaseEntity {

  @EmbeddedId
  private StoreLikesCompositeKey storeLikesCompositeKey;
  private Boolean isLiked;

}
