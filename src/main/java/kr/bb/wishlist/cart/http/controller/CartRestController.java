package kr.bb.wishlist.cart.http.controller;

import bloomingblooms.domain.wishlist.cart.GetUserCartItemsResponse;
import bloomingblooms.response.CommonResponse;
import java.util.List;
import javax.validation.Valid;
import kr.bb.wishlist.cart.dto.command.AddCartItemCommand;
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
import org.springframework.web.bind.annotation.PatchMapping;
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
        feignRequestHandler.getUserCartProductIdAndSelectedQuantity(new UserId(userId))));
  }

  @PostMapping("/carts")
  public CommonResponse<AddCartItemStatus> addCartItem(
      @RequestHeader Long userId, @Valid @RequestBody AddCartItemCommand<ProductId> command) {
    return CommonResponse.success( cartService.addCartItem(new UserId(userId), command.getProductId(),
        command.getSelectedQuantity()));
  }


  @PutMapping("/carts/products")
  public CommonResponse<String> deleteCartItems(
      @RequestHeader Long userId, @Valid @RequestBody List<ProductId> productIdList) {
    cartService.deleteCartItems(new UserId(userId), productIdList);
    return CommonResponse.success("장바구니 상품 삭제 성공");
  }

  @PatchMapping("/carts/products")
  public CommonResponse<String> updateCartItemSelectedQuantity(
      @RequestHeader Long userId, @Valid @RequestBody UpdateCartItemCommand<ProductId> command) {
    cartService.updateCartItemSelectedQuantity(new UserId(userId), command.getProductId(),
        command.getSelectedQuantity());
    return CommonResponse.success("카트 재고 업데이트 성공");

  }

}
