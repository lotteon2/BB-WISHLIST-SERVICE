package kr.bb.wishlist.cart.http.controller;

import bloomingblooms.response.CommonResponse;
import javax.validation.Valid;
import kr.bb.wishlist.cart.dto.CartItemProductIdDto;
import kr.bb.wishlist.cart.dto.DeleteCartItemListCommand;
import kr.bb.wishlist.cart.dto.command.AddCartItemCommand;
import kr.bb.wishlist.cart.dto.command.DeleteCartItemListCommand;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import kr.bb.wishlist.cart.http.message.GetCartItemProductInfoMessageRequest;
import kr.bb.wishlist.cart.service.CartService;
import kr.bb.wishlist.common.valueobject.ProductId;
import kr.bb.wishlist.common.valueobject.UserId;
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
  private final GetCartItemProductInfoMessageRequest messageRequest;

  @GetMapping("/carts")
  public CommonResponse<GetUserCartItemsResponse> getUserCartProducts(
      @RequestHeader Long userId) {
    CartItemProductIdDto productIdList = cartService.getCartItem(new UserId(userId));
    return CommonResponse.success(messageRequest.request(productIdList));
  }

  @PostMapping("/carts")
  public CommonResponse<String> addCartItem(
      @RequestHeader Long userId, @Valid @RequestBody AddCartItemCommand<ProductId> command) {
    cartService.addCartItem(new UserId(userId), command.getProductId(),
        command.getSelectedQuantity());
    return CommonResponse.success("장바구니 상품 담기 성공");
  }


  @PutMapping("/carts/products")
  public CommonResponse<String> deleteCartItmes(
      @RequestHeader Long userId, @Valid @RequestBody DeleteCartItemListCommand command) {
    cartService.deleteCartItems(new UserId(userId), command.getProductIdList());
  }

  @PutMapping("/carts/products/{productId}")
  public CommonResponse<String> updateCartItemSelectedQuantity(
      @RequestHeader Long userId, @Valid @RequestBody UpdatepCartItemCommand command,
      @PathVariable Long productId) {

  }

  ///api/wishlist/carts 상품 담기 POST
  ///api/wishlist/carts/products 삭제
  ///api/wishlist/carts/products/{productId} 수량 조절
}
