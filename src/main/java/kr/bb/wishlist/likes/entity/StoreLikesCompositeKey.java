package kr.bb.wishlist.likes.entity;
import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Embeddable
public class StoreLikesCompositeKey implements Serializable {

  private static final long serialVersionUID = -189479558090736427L;
  private Long userId;
  private Long storeId;

}
