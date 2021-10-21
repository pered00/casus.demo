package casus.casus.demo.service.customer;

import casus.casus.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();
    public Customer addNewCustomer(Customer customer);

}