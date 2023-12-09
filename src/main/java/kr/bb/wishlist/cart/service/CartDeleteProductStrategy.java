package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface CartDeleteProductStrategy<ID extends UserId> {
  public void delete(ID userId);
}
