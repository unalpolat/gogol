package com.app.gogol.bean;

import com.app.gogol.entity.Order;
import com.app.gogol.entity.Order.Status;
import java.util.Date;

/**
 * @author unalpolat
 */
public class OrderDto {

  private final Long id;

  private final Long customerId;

  private final Boolean active;

  private final Status status;

  private final String note;

  private final Integer totalPrice;

  private final Integer deliveryPrice;

  private final Long addressId;

  private final String addressDetails;

  private final Date deliveryDate;

  private OrderDto(Long id, Long customerId, Boolean active, Status status, String note, Integer totalPrice,
                   Integer deliveryPrice, Long addressId, String addressDetails, Date deliveryDate) {
    this.id = id;
    this.customerId = customerId;
    this.active = active;
    this.status = status;
    this.note = note;
    this.totalPrice = totalPrice;
    this.deliveryPrice = deliveryPrice;
    this.addressId = addressId;
    this.addressDetails = addressDetails;
    this.deliveryDate = deliveryDate;
  }

  public static OrderDto from(Order order) {
    return new OrderDto(order.getId(), order.getCustomerId(), order.getActive(), order.getStatus(), order.getNote(),
                        order.getTotalItemPrice(), order.getDeliveryPrice(), order.getAddressId(),
                        order.getAddressDetails(), order.getDeliveryDate());
  }

  public Long getId() {
    return id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public Boolean getActive() {
    return active;
  }

  public Status getStatus() {
    return status;
  }

  public String getNote() {
    return note;
  }

  public Integer getTotalPrice() {
    return totalPrice;
  }

  public Integer getDeliveryPrice() {
    return deliveryPrice;
  }

  public Long getAddressId() {
    return addressId;
  }

  public String getAddressDetails() {
    return addressDetails;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  @Override
  public String toString() {
    return "OrderDto{" +
           "id=" + id +
           ", customerId=" + customerId +
           ", active=" + active +
           ", status=" + status +
           ", note='" + note + '\'' +
           ", totalPrice=" + totalPrice +
           ", deliveryPrice=" + deliveryPrice +
           ", addressId=" + addressId +
           ", addressDetails='" + addressDetails + '\'' +
           ", deliveryDate=" + deliveryDate +
           '}';
  }
}
