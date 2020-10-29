package com.app.gogol.controller;

import com.app.gogol.bean.CustomerDto;
import com.app.gogol.exception.CustomerNotFoundException;
import com.app.gogol.exception.PhoneNumberInUseException;
import com.app.gogol.request.AddCustomerRequest;
import com.app.gogol.request.UpdateCustomerRequest;
import com.app.gogol.response.AppResponse;
import com.app.gogol.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author unalpolat
 */
@Api(value = "Customer API", tags = "Customer")
@RestController
@Validated
@RequestMapping("/api/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{id}")
  public AppResponse<CustomerDto> getCustomer(@PathVariable Long id) throws CustomerNotFoundException {
    return AppResponse.successful(customerService.get(id));
  }

  @PostMapping
  public AppResponse<CustomerDto> addCustomer(@Validated @RequestBody AddCustomerRequest request)
      throws PhoneNumberInUseException {
    return AppResponse.successful(customerService.add(request));
  }

  @PutMapping("/{id}")
  public AppResponse updateCustomer(@Validated @RequestBody UpdateCustomerRequest request)
      throws CustomerNotFoundException {
    customerService.update(request);
    return AppResponse.successful();
  }
}
