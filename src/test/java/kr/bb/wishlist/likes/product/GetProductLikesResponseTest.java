package kr.bb.wishlist.likes.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.entity.ProductLikesCompositeKey;
import kr.bb.wishlist.likes.entity.ProductLikesEntity;
import kr.bb.wishlist.likes.entity.StoreLikesCompositeKey;
import kr.bb.wishlist.likes.entity.StoreLikesEntity;
import kr.bb.wishlist.likes.repository.LikesProductJpaRepository;
import kr.bb.wishlist.likes.repository.LikesStoreJpaRepository;
import kr.bb.wishlist.likes.service.LikesProductServiceImpl;
import kr.bb.wishlist.likes.service.LikesStoreService;
import kr.bb.wishlist.likes.service.LikesStoreServiceImpl;
import kr.bb.wishlist.likes.service.StoreLikesStrategy;
import kr.bb.wishlist.likes.util.StoreIdProjection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetProductLikesResponseTest {


 @InjectMocks
 LikesProductServiceImpl likesStoreService;

 @Mock
 LikesProductJpaRepository repository;


 @Test
 void GetStoreIdList_WhenThereIsReturnedStoreLikesData_GetTheMathcedDataStoreIdList() {
  when(repository.findAllByLikesCompositeKey_UserIdAndAndIsLikedTrue(anyLong())).thenReturn(
      List.of(new ProductLikesEntity(new ProductLikesCompositeKey(1L, "1"), Boolean.TRUE),
          new ProductLikesEntity(new ProductLikesCompositeKey(1L, "2"), Boolean.TRUE)));

  List<ProductId> productIdList = likesStoreService.getProductLikes(new UserId(1L));

  assertEquals("1",  productIdList.get(0).getValue());
  assertEquals("2",  productIdList.get(1).getValue());
 }


}
