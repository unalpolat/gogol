package com.app.gogol.bean;

import com.app.gogol.entity.Customer;

/**
 * @author unalpolat
 */
public class CustomerDto {

  private final Long id;

  private final String firstName;

  private final String lastName;

  private final String email;

  private final String phoneNumber;

  public CustomerDto(Long id, String firstName, String lastName, String email, String phoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public static CustomerDto from(Customer customer) {
    return new CustomerDto(customer.getId(),
                           customer.getFirstName(),
                           customer.getLastName(),
                           customer.getEmail(),
                           customer.getPhoneNumber());
  }

  public Long getId() {
    return id;
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
           ", firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", email='" + email + '\'' +
           ", phoneNumber='" + phoneNumber + '\'' +
           '}';
  }
}
