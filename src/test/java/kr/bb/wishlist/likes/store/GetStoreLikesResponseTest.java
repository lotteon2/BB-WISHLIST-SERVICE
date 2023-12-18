package kr.bb.wishlist.likes.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
import kr.bb.wishlist.likes.repository.LikesStoreJpaRepository;
import kr.bb.wishlist.likes.service.LikesStoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetStoreLikesResponseTest {


  @InjectMocks
  LikesStoreServiceImpl likesStoreService;

  @Mock
  LikesStoreJpaRepository repository;


  @Test
  void GetStoreIdList_WhenThereIsReturnedStoreLikesData_GetTheMathcedDataStoreIdList() {
    when(repository.findAllByStoreLikesCompositeKey_UserId(anyLong())).thenReturn(
        List.of(new StoreLikesEntity(new StoreLikesCompositeKey(1L, 1L), Boolean.TRUE),
            new StoreLikesEntity(new StoreLikesCompositeKey(1L, 2L), Boolean.TRUE)));

    List<StoreId> storeIdList = likesStoreService.getStoreIdLikes(new UserId(1L));

    assertEquals(1L, (long) storeIdList.get(0).getValue());
    assertEquals(2L, (long) storeIdList.get(1).getValue());
  }

}
