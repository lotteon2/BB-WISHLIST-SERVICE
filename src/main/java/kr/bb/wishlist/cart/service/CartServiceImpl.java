package kr.bb.wishlist.cart.service;



import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import kr.bb.wishlist.cart.dto.CartItemProductIdDto;
import kr.bb.wishlist.cart.entity.CartEntity;
import kr.bb.wishlist.cart.exception.CartDomainException;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import kr.bb.wishlist.cart.repository.ProductIdProjection;
import kr.bb.wishlist.cart.util.CartCompkeyMakerUtil;
import kr.bb.wishlist.cart.valueobject.AddCartItemStatus;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements
    CartService<UserId, ProductId> {

  private final UpdateCartItemSelectedQuantityProcessor updateCartItemSelectedQuantityProcessor;
  private final AddCartItemWhenCartItemIsAlreadyExist addCartItemStrategy;
  private final CartJpaRepository repository;


  @Override
  public CartItemProductIdDto getCartItem(UserId userId) {

    List<CartEntity> cartEntityList = repository.findAllByCartCompositekey_UserId(
        userId.getValue());

    List<ProductIdProjection> productIdProjections = filterProductIdList(cartEntityList);

    List<ProductId> productIdList = productIdProjections.stream()
        .map(ProductIdProjection::getProductId)
        .collect(Collectors.toList());

    return new CartItemProductIdDto(productIdList);

  }

  @Override
  public AddCartItemStatus addCartItem(UserId userId, ProductId productId, int selectedQuantity) {
    return addCartItemStrategy.addCartItem(userId, productId, selectedQuantity);
  }

  @Transactional
  @Override
  public void deleteCartItems(UserId userId, List<ProductId> productIdList) {
    for (ProductId productId : productIdList) {
      repository.deleteById(CartCompkeyMakerUtil.cartEntityCompKey(userId,productId));
    }
  }

  @Override
  public void updateCartItemSelectedQuantity(UserId userId, ProductId productId,
      int updatedSelectedQuantity) {
    CartEntity cartEntity = repository.findById(
            CartCompkeyMakerUtil.cartEntityCompKey(userId, productId))
        .orElseThrow(() -> {
          throw new CartDomainException("존재 하지 않는 카트 상품입니다.");
        });
    updateCartItemSelectedQuantityProcessor.update(cartEntity, cartEntity.getSelectedQuantity(),
        updatedSelectedQuantity);
  }

  private List<ProductIdProjection> filterProductIdList(List<CartEntity> cartEntityList) {
    return cartEntityList.stream()
        .map(cartEntity -> ProductIdProjection.createFromLong(
            new ProductId(cartEntity.getCartCompositekey().getProductId())))
        .collect(Collectors.toList());
  }
}
