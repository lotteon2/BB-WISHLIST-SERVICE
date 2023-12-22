package kr.bb.wishlist.likes.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LikedStoreInfoResponse {

  private Long storeId;
  private String storeName;
  private String detailInfo;
  private Float averageRating;
}
