package com.app.gogol.request;

import com.app.gogol.annotation.Email;
import com.app.gogol.annotation.PhoneNumber;
import com.app.gogol.entity.Customer.Status;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author unalpolat
 */
public class UpdateCustomerRequest {

  @NotNull
  @Positive
  private Long id;

  @NotNull
  @Positive
  private Long creatorId;

  @NotBlank
  @Size(max = 190)
  private String firstName;

  @NotBlank
  @Size(max = 190)
  private String lastName;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  @PhoneNumber
  private String phoneNumber;

  @NotNull
  private Status status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Long creatorId) {
    this.creatorId = creatorId;
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

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "UpdateCustomerRequest{" +
           "id=" + id +
           ", creatorId=" + creatorId +
           ", firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", email='" + email + '\'' +
           ", phoneNumber='" + phoneNumber + '\'' +
           ", status=" + status +
           '}';
  }
}
