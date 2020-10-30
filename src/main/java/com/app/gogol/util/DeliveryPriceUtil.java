package com.app.gogol.util;

/**
 * @author unalpolat
 */
public final class DeliveryPriceUtil {

  // there is no delivery price for orders that have bigger than 50 tl total product price
  public static Integer getDeliveryPrice(Integer totalPrice) {
    if (totalPrice < 5000) {
      return 350;
    }
    return 0;
  }
}
