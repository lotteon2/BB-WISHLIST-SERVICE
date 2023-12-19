package kr.bb.wishlist.likes.dto.response;

import kr.bb.wishlist.common.valueobject.StoreId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LikedStoreInfoResponse {

  private StoreId storeId;
  private String storeName;
  private String detailInfo;
  private Float averageRating;
}
