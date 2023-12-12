package kr.bb.wishlist.wish.dto.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StoreIdListDto {

  private List<StoreId> storeIdList;
}
