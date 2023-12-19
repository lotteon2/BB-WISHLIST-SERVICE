package kr.bb.wishlist.cart.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
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
  void GetDESCArrangedTime_WhenCartEntityIsOver2_GetArrangedWithDESC() {
    Long userId = 1L;
    String firstProduct = "1";
    String secondProduct = "2";
    CartEntity cart1 = CartEntity.builder()
        .cartCompositekey(new CartCompositeKey(userId, firstProduct))
        .selectedQuantity(5)
        .build();

    CartEntity cart2 = CartEntity.builder()
        .cartCompositekey(new CartCompositeKey(userId, secondProduct))
        .selectedQuantity(3)
        .build();

    repository.save(cart1);
    repository.save(cart2);

    List<CartEntity> cartEntities = repository.findAllByCartCompositekey_UserId(userId);

    assertTrue(cartEntities != null && !cartEntities.isEmpty());

    assertTrue(
        cartEntities.get(0).getUpdatedAt().compareTo(cartEntities.get(1).getUpdatedAt()) > 0);

  }


  @Test
  void GetCartEntity_WhenCartEntityExistByCompositeKey_GetListOfCartEntity() {

    CartCompositeKey cartCompositekey = new CartCompositeKey(1L, "1");
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
