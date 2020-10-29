package com.app.gogol.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author unalpolat
 */
@Entity
public class CustomerUpdateHistory {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long customerId;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private String email;

  @Column(nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  private Long creatorId;

  @Column(nullable = false)
  private Date createdAt;

  public CustomerUpdateHistory(Long customerId, String firstName, String lastName, String email,
                               String phoneNumber, Long creatorId, Date createdAt) {
    this.customerId = customerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.creatorId = creatorId;
    this.createdAt = createdAt;
  }

  public static CustomerUpdateHistory from(Customer customer, Long creatorId) {
    return new CustomerUpdateHistory(customer.getId(), customer.getFirstName(), customer.getLastName(),
                                     customer.getEmail(), customer.getPhoneNumber(), creatorId, new Date());
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Long creatorId) {
    this.creatorId = creatorId;
  }

  @Override
  public String toString() {
    return "CustomerUpdateHistory{" +
           "id=" + id +
           ", customerId='" + customerId +
           ", firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", email='" + email + '\'' +
           ", phoneNumber='" + phoneNumber + '\'' +
           ", creatorId=" + creatorId +
           ", createdAt=" + createdAt +
           '}';
  }
}
