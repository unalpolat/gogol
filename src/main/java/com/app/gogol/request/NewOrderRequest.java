package com.app.gogol.request;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author unalpolat
 */
public class NewOrderRequest {

  @NotNull
  @Positive
  private Long customerId;

  @Size(max = 1000)
  private String note;

  @NotNull
  @Positive
  private Long addressId;

  @Size(max = 1000)
  private String addressDetails;

  @NotNull
  private Date deliveryDate = new Date();

  @NotEmpty
  @Valid
  List<Item> items;

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public String getAddressDetails() {
    return addressDetails;
  }

  public void setAddressDetails(String addressDetails) {
    this.addressDetails = addressDetails;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "NewOrderRequest{" +
           "customerId=" + customerId +
           ", note='" + note + '\'' +
           ", addressId=" + addressId +
           ", addressDetails='" + addressDetails + '\'' +
           ", deliveryDate=" + deliveryDate +
           ", items=" + items +
           '}';
  }

  public static class Item {

    @NotNull
    @Positive
    private Long id;

    @NotNull
    @Positive
    private Integer quantity;

    @Size(max = 1000)
    private String note;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Integer getQuantity() {
      return quantity;
    }

    public void setQuantity(Integer quantity) {
      this.quantity = quantity;
    }

    public String getNote() {
      return note;
    }

    public void setNote(String note) {
      this.note = note;
    }

    @Override
    public String toString() {
      return "Item{" +
             "id=" + id +
             ", quantity=" + quantity +
             ", note='" + note + '\'' +
             '}';
    }
  }
}
