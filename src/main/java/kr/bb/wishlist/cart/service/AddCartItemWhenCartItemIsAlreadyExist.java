package kr.bb.wishlist.cart.service;


import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface AddCartItemWhenCartItemIsAlreadyExist {

  public void addCartItem(UserId userId, ProductId productId, int selectedQuantity);
}
