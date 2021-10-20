package casus.casus.demo.service.customer;

import casus.casus.demo.model.Customer;
import casus.casus.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return  customerRepository.findAll();


    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
