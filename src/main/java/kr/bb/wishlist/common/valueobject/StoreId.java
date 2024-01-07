package kr.bb.wishlist.common.valueobject;


import java.util.List;
import java.util.stream.Collectors;

public class StoreId extends BaseId<Long> {

  public StoreId(Long value) {
    super(value);
  }

  public static List<StoreId> convertToStoreIdList(List<Long> storeIdValueList) {
    return storeIdValueList.stream()
        .map(StoreId::new)
        .collect(Collectors.toList());

  }
}
