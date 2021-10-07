package casus.casus.demo.service;

import casus.casus.demo.model.Customer;
import casus.casus.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumerServiceImpl implements CustomerService {


    @Autowired
    CustomerRepository costumerRepository;

    @Autowired
    public CostumerServiceImpl(CustomerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<Customer> getCustomers() {
        return  costumerRepository.findAll();

//        return List.of(
//                new Customer("name","adres","postcode","plaats","email")
//        );
    }

    public Customer addNewCustomer(Customer customer) {
        return costumerRepository.save(customer);
    }
}
