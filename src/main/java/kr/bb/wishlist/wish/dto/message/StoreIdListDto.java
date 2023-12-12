package kr.bb.wishlist.wish.dto.message;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StoreIdListDto {

  private List<Long> storeIdList;
}
