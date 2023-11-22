package kr.bb.wishlist.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import kr.bb.wishlist.entity.compositekey.StoreLikesId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "store_likes")
public class StoreLikes extends BaseEntity {
  @EmbeddedId private StoreLikesId id;
}
