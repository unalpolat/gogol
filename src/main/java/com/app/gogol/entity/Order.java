package com.app.gogol.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

/**
 * @author unalpolat
 */
@Entity
@Table(name = "\"order\"",
       indexes = @Index(name = "order_customer_id_index", columnList = "customerId"))
public class Order {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long customerId;

  @Column(nullable = false)
  private Boolean active;

  @Enumerated(STRING)
  @Column(nullable = false)
  private Status status;

  @Enumerated(STRING)
  @Column
  private LastUpdateOperation lastUpdateOperation;

  @Column
  private Long lastUpdaterId;

  @Column(length = 1024)
  private String note;

  // shown as kurus
  @Column(nullable = false)
  private Integer totalItemPrice;

  // shown as kurus
  @Column(nullable = false)
  private Integer deliveryPrice;

  @Column
  private Long addressId;

  @Column(length = 5000)
  private String addressDetails;

  @Column
  @Temporal(DATE)
  private Date deliveryDate;

  @Column(nullable = false)
  private Date createdAt;

  @Column(nullable = false)
  private Date lastUpdatedAt;

  public Order() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public LastUpdateOperation getLastUpdateOperation() {
    return lastUpdateOperation;
  }

  public void setLastUpdateOperation(LastUpdateOperation lastUpdateOperation) {
    this.lastUpdateOperation = lastUpdateOperation;
  }

  public Long getLastUpdaterId() {
    return lastUpdaterId;
  }

  public void setLastUpdaterId(Long lastUpdaterId) {
    this.lastUpdaterId = lastUpdaterId;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Integer getTotalItemPrice() {
    return totalItemPrice;
  }

  public void setTotalItemPrice(Integer totalItemPrice) {
    this.totalItemPrice = totalItemPrice;
  }

  public Integer getDeliveryPrice() {
    return deliveryPrice;
  }

  public void setDeliveryPrice(Integer deliveryPrice) {
    this.deliveryPrice = deliveryPrice;
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
    return "Order{" +
           "id=" + id +
           ", customerId=" + customerId +
           ", active=" + active +
           ", status=" + status +
           ", lastUpdateOperation=" + lastUpdateOperation +
           ", lastUpdaterId=" + lastUpdaterId +
           ", note='" + note + '\'' +
           ", totalItemPrice=" + totalItemPrice +
           ", deliveryPrice=" + deliveryPrice +
           ", addressId=" + addressId +
           ", addressDetails='" + addressDetails + '\'' +
           ", deliveryDate=" + deliveryDate +
           ", createdAt=" + createdAt +
           ", lastUpdatedAt=" + lastUpdatedAt +
           '}';
  }

  public enum Status {
    CREATED,
    IN_DELIVERY,
    COMPLETED
  }

  public enum LastUpdateOperation {
    UPDATE,
    CANCEL,
    RESCHEDULE,
    UPDATE_ADDRESS
  }
}
