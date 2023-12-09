package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.cart.repository.CartJpaRepository;
import kr.bb.wishlist.cart.util.CartCompkeyMakerUtil;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCartItemWhenRequestUnder0 implements
    CartDeleteCartItemStrategy<UserId,ProductId> {

  private final CartJpaRepository repository;

  @Override
  public void delete(UserId userId, ProductId productId) {
    repository.deleteById(CartCompkeyMakerUtil.cartEntityCompKey(userId,productId));
  }

}
