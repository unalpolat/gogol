package com.app.gogol.repository;

import com.app.gogol.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author unalpolat
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
