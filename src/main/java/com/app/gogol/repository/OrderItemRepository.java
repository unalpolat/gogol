package com.app.gogol.repository;

import com.app.gogol.entity.OrderItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author unalpolat
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

  @Query(value = "SELECT * FROM order_item WHERE order_id = :orderId", nativeQuery = true)
  List<OrderItem> selectByOrderId(Long orderId);
}
