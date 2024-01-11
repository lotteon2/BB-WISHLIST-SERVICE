package kr.bb.wishlist.cart.adapter.input;

import bloomingblooms.dto.command.CartDeleteCommand;
import bloomingblooms.dto.command.CartDeleteDto;
import java.util.ArrayList;
import java.util.List;

import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.port.input.DeleteCartItemEventListener;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
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
 public void delete(@Payload CartDeleteCommand dto) {
  repository.deleteAllById(getCartCompositeKeyList(dto));
 }

 private List<CartCompositeKey> getCartCompositeKeyList(CartDeleteCommand command) {
  List<CartCompositeKey> cartCompositeKeys = new ArrayList<>();
 List<CartDeleteDto> dtoList = command.getCartDeleteDtoList();

  for (CartDeleteDto dto: dtoList) {
   Long userId = dto.getUserId();
   String productId = dto.getProductId();

   CartCompositeKey cartCompositeKey = new CartCompositeKey(userId, productId);
   cartCompositeKeys.add(cartCompositeKey);
  }

  return cartCompositeKeys;
 }
}
