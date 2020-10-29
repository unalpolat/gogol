package com.app.gogol.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author unalpolat
 */
@Entity
@Table(indexes = @Index(name = "order_item_order_id_index", columnList = "orderId"))
public class OrderItem {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long orderId;

  @Column(nullable = false)
  private Long productId;

  // shown as kurus
  @Column(nullable = false)
  private Integer price;

  // shown as kurus
  @Column(nullable = false)
  private Integer quantity;

  @Column(length = 1024)
  private String note;

  @Column(nullable = false)
  private Date createdAt;

  @Column(nullable = false)
  private Date lastUpdatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getLastUpdatedAt() {
    return lastUpdatedAt;
  }

  public void setLastUpdatedAt(Date lastUpdatedAt) {
    this.lastUpdatedAt = lastUpdatedAt;
  }

  @Override
  public String toString() {
    return "OrderItem{" +
           "id=" + id +
           ", orderId=" + orderId +
           ", productId=" + productId +
           ", price=" + price +
           ", quantity=" + quantity +
           ", note='" + note + '\'' +
           ", createdAt=" + createdAt +
           ", lastUpdatedAt=" + lastUpdatedAt +
           '}';
  }
}
