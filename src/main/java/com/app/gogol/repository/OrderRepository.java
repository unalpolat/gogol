package com.app.gogol.repository;

import com.app.gogol.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author unalpolat
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  List<Order> findByCustomerId(Long customerId);
}
