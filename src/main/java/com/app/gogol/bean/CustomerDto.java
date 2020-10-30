package com.app.gogol.bean;

import com.app.gogol.entity.Customer;

import static com.app.gogol.entity.Customer.Status;

/**
 * @author unalpolat
 */
public class CustomerDto {

  private final Long id;

  private final Status status;

  private final String firstName;

  private final String lastName;

  private final String email;

  private final String phoneNumber;

  private CustomerDto(Long id, Status status, String firstName, String lastName,
                      String email, String phoneNumber) {
    this.id = id;
    this.status = status;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public static CustomerDto from(Customer customer) {
    return new CustomerDto(customer.getId(),
                           customer.getStatus(),
                           customer.getFirstName(),
                           customer.getLastName(),
                           customer.getEmail(),
                           customer.getPhoneNumber());
  }

  public Long getId() {
    return id;
  }

  public Status getStatus() {
    return status;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public String toString() {
    return "CustomerDto{" +
           "id=" + id +
           ", status=" + status +
           ", firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", email='" + email + '\'' +
           ", phoneNumber='" + phoneNumber + '\'' +
           '}';
  }
}
