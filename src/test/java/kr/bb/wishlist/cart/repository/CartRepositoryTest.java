package kr.bb.wishlist.cart.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

import java.util.List;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.entity.CartEntity;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CartRepositoryTest {

  @Autowired
  CartJpaRepository repository;

  @Test
  void GetCartEntity_WhenCartEntityExistByCompositeKey_GetListOfCartEntity() {

    CartCompositeKey cartCompositekey = new CartCompositeKey(anyLong(), anyLong());
    CartEntity cartEntity = CartEntity.builder().cartCompositekey(cartCompositekey)
        .selectedQuantity(
            ArgumentMatchers.anyInt()).build();

    repository.save(cartEntity);

    List<CartEntity> cartEntityList = repository.findAllByCartCompositekey_UserId(
        cartCompositekey.getUserId());

    assertTrue(cartEntityList.size() != 0);

  }

  @Test
  void GetCartEntity_WhenCartEntityIsNotExistByCompositeKey_GetSize0CartEntityList() {

    List<CartEntity> cartEntityList = repository.findAllByCartCompositekey_UserId(
        anyLong());

    assertTrue(cartEntityList.size() == 0);
  }
}
