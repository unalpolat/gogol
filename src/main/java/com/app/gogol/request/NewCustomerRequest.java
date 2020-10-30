package com.app.gogol.request;

import com.app.gogol.annotation.Email;
import com.app.gogol.annotation.PhoneNumber;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author unalpolat
 */
public class NewCustomerRequest {

  @Size(max = 190)
  private String firstName;

  @Size(max = 190)
  private String lastName;

  @Email
  private String email;

  @NotEmpty
  @PhoneNumber
  private String phoneNumber;

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

  @Override
  public String toString() {
    return "AddCustomerRequest{" +
           "firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", email='" + email + '\'' +
           ", phoneNumber='" + phoneNumber + '\'' +
           '}';
  }
}
