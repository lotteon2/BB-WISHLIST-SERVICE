package kr.bb.wishlist.cart.adapter.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.port.input.DeleteCartItemEventListener;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCartItemEventListenerImpl implements
    DeleteCartItemEventListener<UserId, ProductId> {

 private final CartJpaRepository repository;

 @KafkaListener(topics = "cart-delete",
     groupId = "cart-delete-group")
 @Override
 public void delete(Map<UserId, ProductId> userIdProductIdMap) {
  repository.deleteAllById(getCartCompositeKeyList(userIdProductIdMap));
 }

 private List<CartCompositeKey> getCartCompositeKeyList(Map<UserId, ProductId> userIdProductIdMap) {
  List<CartCompositeKey> cartCompositeKeys = new ArrayList<>();

  for (Map.Entry<UserId, ProductId> entry : userIdProductIdMap.entrySet()) {
   UserId userId = entry.getKey();
   ProductId productId = entry.getValue();

   CartCompositeKey cartCompositeKey = new CartCompositeKey(userId.getValue(), productId.getValue());
   cartCompositeKeys.add(cartCompositeKey);
  }

  return cartCompositeKeys;
 }
}
