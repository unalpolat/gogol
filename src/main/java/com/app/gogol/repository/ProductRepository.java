package com.app.gogol.repository;

import com.app.gogol.entity.Product;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author unalpolat
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Modifying
  @Query(value = "UPDATE product SET stock_quantity = :newQuantity, last_updated_at = :lastUpdatedAt "
                 + "WHERE id = :id", nativeQuery = true)
  void destock(Long id, Integer newQuantity, Date lastUpdatedAt);
}
