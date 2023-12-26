package kr.bb.wishlist.likes.http.message;

import bloomingblooms.domain.wishlist.likes.LikedProductInfoResponse;
import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.likes.http.feign.GetLikedProductInfoFeignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikedProductInfoRequestImpl implements
    LikedProductInfoRequest<ProductId> {

  private final GetLikedProductInfoFeignRequest feignRequest;

  @Override
  public LikedProductInfoResponse request(List<ProductId> productIdList, Pageable pageable) {
    return feignRequest.getProductDetailWhichUserLiked(ProductId.convertList(productIdList),pageable)
        .getData();
  }

}
