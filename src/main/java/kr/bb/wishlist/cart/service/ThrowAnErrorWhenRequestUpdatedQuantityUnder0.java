package kr.bb.wishlist.cart.service;

import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.exception.CartDomainException;
import kr.bb.wishlist.cart.mapper.CartMapper;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThrowAnErrorWhenRequestUpdatedQuantityUnder0 implements
    DecreaseCartItemSelectedQuantityStrategy {

  private final CartJpaRepository repository;
  @Override
  public void decreaseCartItemSelectedQuantity(CartEntity cartEntity, int stock,
      int updatedDecreasedStock) {
    if(updatedDecreasedStock < 1){
      throw new CartDomainException("1개 미만으로는 상품의 재고를 업데이트 할 수 없습니다.");
    }
    repository.save(CartMapper.getCartEntityWithUpdatedSelectedQuantity(cartEntity,updatedDecreasedStock));
  }
}
