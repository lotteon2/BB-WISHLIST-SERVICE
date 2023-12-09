package kr.bb.wishlist.cart.entity;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartEntity {


  private int selectedQuantity;

}
