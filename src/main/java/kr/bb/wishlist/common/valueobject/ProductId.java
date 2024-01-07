package kr.bb.wishlist.common.valueobject;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
public class ProductId extends BaseId<String> {

  public ProductId(String value) {
    super(value);
  }



  public static List<String> convertList(List<ProductId> productIdList) {
    return productIdList.stream()
        .map(BaseId::getValue)
        .collect(Collectors.toList());
  }
}
