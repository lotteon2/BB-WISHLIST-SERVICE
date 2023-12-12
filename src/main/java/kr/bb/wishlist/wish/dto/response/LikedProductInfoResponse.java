package kr.bb.wishlist.wish.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LikedProductInfoResponse {
  private String productId;
  private String productName;
  private String productSummary;
  private Long productPrice;
  private Float averageRating;

}
