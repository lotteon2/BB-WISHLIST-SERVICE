package kr.bb.wishlist.cart.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.entity.CartEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class CartRepositoryTest {

  @Autowired
  private CartJpaRepository repository;

  @Test
  void GetCartEntity_WhenCartEntityExistByCompositeKey_GetListOfCartEntity() {

    CartCompositeKey cartCompositekey = new CartCompositeKey(1L,"1");
    CartEntity cartEntity = CartEntity.builder().cartCompositekey(cartCompositekey)
        .selectedQuantity(
            1).build();

    repository.save(cartEntity);

    List<CartEntity> cartEntityList = repository.findAllByCartCompositekey_UserId(
        cartCompositekey.getUserId());

    assertTrue(cartEntityList.size() != 0);

  }

  @Test
  void GetCartEntity_WhenCartEntityIsNotExistByCompositeKey_GetSize0CartEntityList() {

    List<CartEntity> cartEntityList = repository.findAllByCartCompositekey_UserId(
        1L);

    assertTrue(cartEntityList.size() == 0);
  }
}
