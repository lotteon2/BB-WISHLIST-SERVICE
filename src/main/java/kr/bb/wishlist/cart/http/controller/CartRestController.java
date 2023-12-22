package kr.bb.wishlist.cart.http.controller;

import bloomingblooms.domain.wishlist.cart.GetUserCartItemsResponse;
import bloomingblooms.response.CommonResponse;
import javax.validation.Valid;
import kr.bb.wishlist.cart.dto.command.AddCartItemCommand;
import kr.bb.wishlist.cart.dto.command.DeleteCartItemListCommand;
import kr.bb.wishlist.cart.dto.command.UpdateCartItemCommand;
import kr.bb.wishlist.cart.http.message.GetCartItemProductInfoMessageRequest;
import kr.bb.wishlist.cart.service.CartService;
import kr.bb.wishlist.cart.valueobject.AddCartItemStatus;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.StoreId;
import kr.bb.wishlist.common.valueobject.UserId;
import kr.bb.wishlist.likes.http.feign.handler.FeignRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartRestController {

  private final CartService<UserId, ProductId> cartService;
  private final GetCartItemProductInfoMessageRequest productInfoRequest;
  private final FeignRequestHandler<UserId, ProductId, StoreId> feignRequestHandler;

  @GetMapping("/carts")
  public CommonResponse<GetUserCartItemsResponse> getUserCartProducts(
      @RequestHeader Long userId) {

    return CommonResponse.success(productInfoRequest.request(
        feignRequestHandler.getUserLikesProductIdAndSelectedQuantity(new UserId(userId))));
  }

  @PostMapping("/carts")
  public CommonResponse<AddCartItemStatus> addCartItem(
      @RequestHeader Long userId, @Valid @RequestBody AddCartItemCommand<ProductId> command) {
    return CommonResponse.success( cartService.addCartItem(new UserId(userId), command.getProductId(),
        command.getSelectedQuantity()));
  }


  @PutMapping("/carts/products")
  public CommonResponse<String> deleteCartItems(
      @RequestHeader Long userId, @Valid @RequestBody DeleteCartItemListCommand command) {
    cartService.deleteCartItems(new UserId(userId), command.getProductIdList());
    return CommonResponse.success("장바구니 상품 삭제 성공");
  }

  @PutMapping("/carts/products/{productId}")
  public CommonResponse<String> updateCartItemSelectedQuantity(
      @RequestHeader Long userId, @Valid @RequestBody UpdateCartItemCommand command,
      @PathVariable String productId) {
    cartService.updateCartItemSelectedQuantity(new UserId(userId), new ProductId(productId),
        command.getUpdatedQuantity());
    return CommonResponse.success("카트 재고 업데이트 성공");

  }

}
