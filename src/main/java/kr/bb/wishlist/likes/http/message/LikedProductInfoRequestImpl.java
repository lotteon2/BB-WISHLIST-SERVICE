package kr.bb.wishlist.likes.http.message;

import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.likes.dto.response.LikedProductInfoResponse;
import kr.bb.wishlist.likes.http.feign.GetLikedProductInfoFeignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikedProductInfoRequestImpl implements
    LikedProductInfoRequest<ProductId> {

  private final GetLikedProductInfoFeignRequest feignRequest;

  @Override
  public LikedProductInfoResponse request(List<ProductId> productIdList) {
    return feignRequest.getProductDetailWhichUserLiked(ProductId.convertList(productIdList))
        .getData();
  }

}
