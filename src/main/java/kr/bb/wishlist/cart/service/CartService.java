package kr.bb.wishlist.cart.service;

import java.util.List;
import kr.bb.wishlist.cart.dto.CartItemProductIdDto;
import kr.bb.wishlist.cart.valueobject.AddCartItemStatus;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.springframework.stereotype.Service;

@Service
public interface CartService<UID extends UserId, PID extends ProductId> {
   CartItemProductIdDto getCartItem(UID userId);
   AddCartItemStatus addCartItem(UID userId, PID productId, Long  selectedQuantity);
   void deleteCartItems(UID userId, List<PID> productIdList);
   void updateCartItemSelectedQuantity(UID userId, PID productId, Long totalSelectedQuantity);
}
