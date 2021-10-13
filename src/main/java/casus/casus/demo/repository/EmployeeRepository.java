package casus.casus.demo.repository;


import casus.casus.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}

// vb   @Query(" SELECT c FROM Customer c WHERE c.email = ?1")
//    Optional<Customer> findCustomerByEmail(String email);


