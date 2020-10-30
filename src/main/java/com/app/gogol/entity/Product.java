package com.app.gogol.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author unalpolat
 */
@Entity
@Table
public class Product {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column
  private String description;

  // shown as kurus
  @Column(nullable = false)
  private Integer price;

  @Column(nullable = false)
  private Integer stockQuantity;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(Integer stockQuantity) {
    this.stockQuantity = stockQuantity;
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
    return "Product{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", description='" + description + '\'' +
           ", price=" + price +
           ", stockQuantity=" + stockQuantity +
           ", createdAt=" + createdAt +
           ", lastUpdatedAt=" + lastUpdatedAt +
           '}';
  }
}
