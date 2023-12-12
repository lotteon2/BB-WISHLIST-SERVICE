package kr.bb.wishlist.common.valueobject;

import java.util.Objects;

public abstract class CompkeyId<T1, T2> {

  private T1 firstValue;
  private T2 secondValue;

  @Override

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompkeyId<T1, T2> key = (CompkeyId<T1, T2>) o;

    return firstValue.equals(key.firstValue) || secondValue.equals(key.secondValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstValue, secondValue);
  }

}