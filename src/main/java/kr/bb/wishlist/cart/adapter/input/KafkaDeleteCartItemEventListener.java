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
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaDeleteCartItemEventListener implements
    DeleteCartItemEventListener {

 private final CartJpaRepository repository;

 @KafkaListener(topics = "cart-delete",
     groupId = "cart-delete-group")
 @Override
 public void delete(@Payload Map<Long, String> userIdProductIdMap) {
  repository.deleteAllById(getCartCompositeKeyList(userIdProductIdMap));
 }

 private List<CartCompositeKey> getCartCompositeKeyList(Map<Long, String> userIdProductIdMap) {
  List<CartCompositeKey> cartCompositeKeys = new ArrayList<>();

  for (Map.Entry<Long,String> entry : userIdProductIdMap.entrySet()) {
   Long userId = entry.getKey();
   String productId = entry.getValue();

   CartCompositeKey cartCompositeKey = new CartCompositeKey(userId, productId);
   cartCompositeKeys.add(cartCompositeKey);
  }

  return cartCompositeKeys;
 }
}
