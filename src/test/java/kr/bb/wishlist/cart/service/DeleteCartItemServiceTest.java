package kr.bb.wishlist.cart.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import kr.bb.wishlist.cart.entity.CartCompositeKey;
import kr.bb.wishlist.cart.repository.CartJpaRepository;
import kr.bb.wishlist.cart.util.CartCompkeyMakerUtil;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeleteCartItemServiceTest {

  @Mock
  private CartJpaRepository repository;
  @InjectMocks
  private CartServiceImpl cartService;

  @DisplayName("카트에 상품이 존재할 때 상품 삭제")
  @Test
  void DeleteCartItem_WhenCartItemExist_deleteByIdIsOccurredAsSizeOfList() {
    List<ProductId> productIdList = List.of(new ProductId("1"));

    cartService.deleteCartItems(
        new UserId(anyLong()), productIdList);

    verify(repository).deleteById(any());
  }

  @Test
  void DeleteCartItem_WhenCartIsNotExist_deleteIsNotHappened() {
    List<ProductId> emptyProductIdList = new ArrayList<>();

    cartService.deleteCartItems(
        mock(UserId.class), emptyProductIdList);

    verify(repository, never()).deleteById(any());
  }

}