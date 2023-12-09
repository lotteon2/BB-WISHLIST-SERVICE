package kr.bb.wishlist.cart.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import kr.bb.wishlist.cart.dto.CartItemProductIdDto;
import kr.bb.wishlist.cart.entity.CartCompositekey;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import kr.bb.wishlist.cart.repository.ProductIdProjection;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements
    CartService<UserId, ProductId> {

  private final AddCartItemWhenCartItemIsAlreadyExist addCartItemStrategy;
  private final CartDeleteCartItemStrategy<UserId, ProductId> deleteCartItemStrategy;
  private final CartJpaRepository repository;

  @Override
  public CartItemProductIdDto getCartItem(UserId userId) {
    List<ProductIdProjection> productIdProjections = repository.findAllByCartCompositekey_UserId(
        userId.getValue());

    List<Long> productIdList = productIdProjections.stream()
        .map(ProductIdProjection::getProductId)
        .collect(Collectors.toList());

    return new CartItemProductIdDto(productIdList);

  }

  @Override
  public void addCartItem(UserId userId, ProductId productId, int selectedQuantity) {
    addCartItemStrategy.addCartItem(userId,productId,selectedQuantity);
  }

  @Transactional
  @Override
  public void deleteCartItems(UserId userId, List<ProductId> productIdList) {
    for(ProductId productId: productIdList){
      deleteCartItemStrategy.delete(userId,productId);
    }
  }

  private CartCompositekey getCartCompKey(UserId userId, ProductId productId) {
    return new CartCompositekey(userId.getValue(), productId.getValue());

  }
}
