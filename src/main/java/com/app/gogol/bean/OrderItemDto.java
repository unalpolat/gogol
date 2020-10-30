package com.app.gogol.bean;

import com.app.gogol.entity.OrderItem;
import com.app.gogol.entity.Product;

/**
 * @author unalpolat
 */
public class OrderItemDto {

  private final Long id;

  private final Long productId;

  private final String note;

  private final Integer price;

  private final Integer quantity;

  private final String name;

  private final Integer remainingStockQuantity;

  private OrderItemDto(Long id, Long productId, String note, Integer price, Integer quantity, String name,
                       Integer remainingStockQuantity) {
    this.id = id;
    this.productId = productId;
    this.note = note;
    this.price = price;
    this.quantity = quantity;
    this.name = name;
    this.remainingStockQuantity = remainingStockQuantity;
  }

  public static OrderItemDto from(OrderItem orderItem, Product product) {
    return new OrderItemDto(orderItem.getId(), orderItem.getProductId(), orderItem.getNote(), orderItem.getPrice(),
                            orderItem.getQuantity(), product.getName(), product.getStockQuantity());
  }

  public Long getId() {
    return id;
  }

  public Long getProductId() {
    return productId;
  }

  public String getNote() {
    return note;
  }

  public Integer getPrice() {
    return price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public String getName() {
    return name;
  }

  public Integer getRemainingStockQuantity() {
    return remainingStockQuantity;
  }

  @Override
  public String toString() {
    return "OrderItemDto{" +
           "id=" + id +
           ", productId=" + productId +
           ", note='" + note + '\'' +
           ", price=" + price +
           ", quantity=" + quantity +
           ", name='" + name + '\'' +
           ", remainingStockQuantity=" + remainingStockQuantity +
           '}';
  }
}
