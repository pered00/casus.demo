package casus.casus.demo.repository;

import casus.casus.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//        @Query (" SELECT c FROM Customer c WHERE c.email = ?1")
//        Optional<Customer> findCustomerByEmail(String email);
        Customer findByName(String Name);
}
