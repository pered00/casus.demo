package casus.casus.demo.service.customer;

import casus.casus.demo.model.Customer;
import casus.casus.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    //POST-PUT (create-update)
    Customer saveObject(Customer object);
    //GET ID / READ / Find by ID EASY
    Customer getObjectByID (Long id);
    //GET ByName/  Read
    Customer getByName(String name);
    //GET ALL / READ
    List<Customer> findAll();
    //DELETE
    String deleteObject(long id);
}
