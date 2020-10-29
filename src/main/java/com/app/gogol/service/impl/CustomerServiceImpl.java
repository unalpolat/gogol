package com.app.gogol.service.impl;

import com.app.gogol.bean.CustomerDto;
import com.app.gogol.entity.Customer;
import com.app.gogol.entity.CustomerUpdateHistory;
import com.app.gogol.exception.CustomerNotFoundException;
import com.app.gogol.exception.PhoneNumberInUseException;
import com.app.gogol.repository.CustomerRepository;
import com.app.gogol.repository.CustomerUpdateHistoryRepository;
import com.app.gogol.request.AddCustomerRequest;
import com.app.gogol.request.UpdateCustomerRequest;
import com.app.gogol.service.CustomerService;
import java.util.Date;
import java.util.Optional;
import org.springframework.stereotype.Service;

import static com.app.gogol.entity.Customer.Status.ACTIVE;
import static com.app.gogol.entity.Customer.Status.PASSIVE;

/**
 * @author unalpolat
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository repository;

  private final CustomerUpdateHistoryRepository historyRepository;

  public CustomerServiceImpl(CustomerRepository repository,
                             CustomerUpdateHistoryRepository historyRepository) {
    this.repository = repository;
    this.historyRepository = historyRepository;
  }

  @Override
  public CustomerDto get(Long id) throws CustomerNotFoundException {
    Optional<Customer> customer = repository.findById(id);
    return customer.map(CustomerDto::from).orElseThrow(() -> new CustomerNotFoundException(id));
  }

  @Override
  public void update(UpdateCustomerRequest request) throws CustomerNotFoundException {
    Optional<Customer> optionalCustomer = repository.findById(request.getId());
    if (optionalCustomer.isEmpty()) {
      throw new CustomerNotFoundException(request.getId());
    }
    // if active customer exists with same phone number, make him/her passive.
    Date now = new Date();
    Optional<Customer> activeCustomer = repository.selectActiveByPhoneNumber(request.getPhoneNumber());
    activeCustomer.ifPresent(customer -> {
      repository.updateStatus(customer.getId(), PASSIVE.name(), now);
      historyRepository.save(CustomerUpdateHistory.from(customer, request.getCreatorId()));
    });
    //
    repository.update(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPhoneNumber(),
                      request.getStatus().name(), now);
    saveToHistory(request, now);
  }

  private void saveToHistory(UpdateCustomerRequest request, Date now) {
    historyRepository.save(new CustomerUpdateHistory(request.getId(), request.getFirstName(), request.getLastName(),
                                                     request.getEmail(), request.getPhoneNumber(),
                                                     request.getCreatorId(), now));
  }

  @Override
  public CustomerDto add(AddCustomerRequest request) throws PhoneNumberInUseException {
    checkPhoneNumberInUse(request.getPhoneNumber());
    Customer customer = createNewCustomer(request);
    Customer newCustomer = repository.save(customer);
    return CustomerDto.from(newCustomer);
  }

  private void checkPhoneNumberInUse(String phoneNumber) throws PhoneNumberInUseException {
    Boolean phoneNumberInUse = repository.selectActiveByPhoneNumber(phoneNumber).isPresent();
    if (phoneNumberInUse) {
      throw new PhoneNumberInUseException();
    }
  }

  private Customer createNewCustomer(AddCustomerRequest request) {
    Customer customer = new Customer();
    customer.setFirstName(request.getFirstName());
    customer.setLastName(request.getLastName());
    customer.setEmail(request.getEmail());
    customer.setPhoneNumber(request.getPhoneNumber());
    Date now = new Date();
    customer.setCreatedAt(now);
    customer.setLastUpdatedAt(now);
    customer.setStatus(ACTIVE);
    return customer;
  }
}
