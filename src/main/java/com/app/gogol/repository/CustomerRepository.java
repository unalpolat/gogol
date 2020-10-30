package com.app.gogol.repository;

import com.app.gogol.entity.Customer;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author unalpolat
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Query(value = "SELECT * FROM customer WHERE phone_number = :phoneNumber AND status = 'ACTIVE' LIMIT 1",
         nativeQuery = true)
  Optional<Customer> selectActiveByPhoneNumber(String phoneNumber);

  @Modifying
  @Query(value = "UPDATE customer SET first_name = :firstName, last_name = :lastName, email = :email, "
                 + "phone_number = :phoneNumber, status = :status, last_updated_at = :lastUpdatedAt",
         nativeQuery = true)
  Integer update(String firstName, String lastName, String email, String phoneNumber, String status,
                 Date lastUpdatedAt);

  @Modifying
  @Query(value = "UPDATE customer SET status = :status, last_updated_at = :lastUpdatedAt WHERE id =:id",
         nativeQuery = true)
  Integer updateStatus(Long id, String status, Date lastUpdatedAt);
}
