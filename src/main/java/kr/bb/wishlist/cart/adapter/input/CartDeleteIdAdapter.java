package kr.bb.wishlist.cart.adapter.input;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

@Component
public class CartDeleteIdAdapter implements Deserializer<Map<UserId, ProductId>> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public Map<UserId, ProductId> deserialize(String topic, byte[] data) {
    try {
      return objectMapper.readValue(data, new TypeReference<Map<UserId, ProductId>>() {
      });

    } catch (IOException e) {
      throw new IllegalArgumentException("Kafka Type mismatch");
    }
  }

}
