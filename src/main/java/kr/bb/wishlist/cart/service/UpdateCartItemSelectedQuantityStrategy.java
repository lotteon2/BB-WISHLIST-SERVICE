package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.common.valueobject.CompkeyId;
import org.springframework.stereotype.Service;

@Service
public interface UpdateCartItemSelectedQuantityStrategy<ID extends CompkeyId> {
  public void update(ID cartCompykey);
}
