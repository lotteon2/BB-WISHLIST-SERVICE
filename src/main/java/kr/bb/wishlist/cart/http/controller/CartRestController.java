package kr.bb.wishlist.cart.http.controller;

import bloomingblooms.response.CommonResponse;
import javax.validation.Valid;
import kr.bb.wishlist.cart.dto.response.GetUserCartItemsResponse;
import kr.bb.wishlist.cart.service.CartService;
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

  private final CartService<UserId> cartService;

  @GetMapping("/carts")
  public CommonResponse<GetUserCartItemsResponse> getUserCartProducts(
      @RequestHeader Long userId) {
//    return CommonResponse.success(cartService.getCartItem(new UserId(userId)));
  }

  @PostMapping("/carts")
  public CommonResponse<String> addCartItem(
      @RequestHeader Long userId, @Valid @RequestBody AddCartItemCommand command) {

  }

  @PutMapping("/carts/products")
  public CommonResponse<String> addCartItem(
      @RequestHeader Long userId, @Valid @RequestBody DeleteProductListCommand command) {

  }

  @PutMapping("/carts/products")
  public CommonResponse<String> addCartItem(
      @RequestHeader Long userId, @Valid @RequestBody DeleteCartItemListCommand command) {

  }

  @PutMapping("/carts/products/{productId}")
  public CommonResponse<String> addCartItem(
      @RequestHeader Long userId, @Valid @RequestBody UpdatepCartItemCommand command,
      @PathVariable Long productId) {

  }

  ///api/wishlist/carts 상품 담기 POST
  ///api/wishlist/carts/products 삭제
  ///api/wishlist/carts/products/{productId} 수량 조절
}
