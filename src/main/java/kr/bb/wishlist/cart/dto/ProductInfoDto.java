package kr.bb.wishlist.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductInfoDto {

	private Long productId;
	private String productName;
	private Long quantity;
	private Long price;
	private String productThumbnailImage;

}
