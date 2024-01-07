package kr.bb.wishlist.likes.store;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.service.ChangeLikedStatusWhenRequestTwice;
import kr.bb.wishlist.likes.service.LikesStoreServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DoStoreLikesServiceTest {

  @Mock
  private ChangeLikedStatusWhenRequestTwice statusChangeWhenRequestTwice;
  @InjectMocks
  private LikesStoreServiceImpl likesStoreService;

  @DisplayName("StoreIdList의 사이즈가 0인 경우 strategy service call을 하지 않음  ")
  @Test
  void CallStrategyInterface_WhenStoreIdListSizeIs0_DoNotStrategyInteface() {
    List<StoreId> storeIdList = List.of();

    likesStoreService.likes(storeIdList, new UserId(1L));

    verify(statusChangeWhenRequestTwice, never()).likes(any(), any());

  }


  @DisplayName("StoreIdList의 사이즈가 0이 아닐 경우 strategy service call  ")
  @Test
  void CallStrategyInterface_WhenStoreIdListSizeIsNot0_CallStrategyInterface() {
    List<StoreId> storeIdList = List.of(new StoreId(1L));

    likesStoreService.likes(storeIdList, new UserId(1L));

    verify(statusChangeWhenRequestTwice, times(1)).likes(any(), any());
  }

}
