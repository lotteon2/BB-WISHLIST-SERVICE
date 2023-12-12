package kr.bb.wishlist.wish.service;

import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.wish.valueobject.LikeStatus;
import org.springframework.stereotype.Service;

@Service
public interface LikesProductService {

  public void likesProduct(List<ProductId> productIdList, UserId userId);
  public List<ProductId> getProductLikes(UserId userId);
}
