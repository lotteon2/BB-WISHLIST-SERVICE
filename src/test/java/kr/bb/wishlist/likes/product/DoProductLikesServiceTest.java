package kr.bb.wishlist.likes.product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.service.LikesProductServiceImpl;
import kr.bb.wishlist.likes.service.LikesProductStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DoProductLikesServiceTest {

  @Mock
  private LikesProductStrategy<ProductId> strategy;
  @InjectMocks
  private LikesProductServiceImpl likesProductService;

  @DisplayName("StoreIdList의 사이즈가 0인 경우 strategy service call을 하지 않음  ")
  @Test
  void CallStrategyInterface_WhenStoreIdListSizeIs0_DoNotStrategyInteface() {
    List<ProductId> productIdList = List.of();

    likesProductService.likesProduct(productIdList, new UserId(1L));

    verify(strategy, never()).likes(any(), any());

  }

  @DisplayName("StoreIdList의 사이즈가 0이 아닐 경우 strategy service call  ")
  @Test
  void CallStrategyInterface_WhenStoreIdListSizeIsNot0_CallStrategyInterface() {
    List<ProductId> productIdList = List.of(new ProductId("1"));

    likesProductService.likesProduct(productIdList, new UserId(1L));

    verify(strategy, times(1)).likes(any(), any());
  }


}
