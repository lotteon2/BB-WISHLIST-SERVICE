package kr.bb.wishlist.entity.compositekey;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreLikesId implements Serializable {
  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "store_id", nullable = false)
  private Long productId;
}
