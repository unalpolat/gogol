package com.app.gogol.repository;

import com.app.gogol.entity.CustomerUpdateHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author unalpolat
 */
@Repository
public interface CustomerUpdateHistoryRepository extends CrudRepository<CustomerUpdateHistory, Long> {

}
