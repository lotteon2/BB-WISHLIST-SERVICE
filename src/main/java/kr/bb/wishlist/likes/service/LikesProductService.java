package kr.bb.wishlist.likes.service;

import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface LikesProductService<ID extends ProductId> {

  public void likesProduct(List<ID> productIdList, UserId userId);
  public List<ID> getProductLikes(UserId userId);
}
