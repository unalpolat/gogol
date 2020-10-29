package com.app.gogol.service;

import com.app.gogol.bean.CustomerDto;
import com.app.gogol.exception.CustomerNotFoundException;
import com.app.gogol.exception.PhoneNumberInUseException;
import com.app.gogol.request.AddCustomerRequest;
import com.app.gogol.request.UpdateCustomerRequest;

/**
 * @author unalpolat
 */
public interface CustomerService {

  CustomerDto get(Long id) throws CustomerNotFoundException;

  void update(UpdateCustomerRequest request) throws CustomerNotFoundException;

  CustomerDto add(AddCustomerRequest request) throws PhoneNumberInUseException;
}
