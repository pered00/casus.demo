package casus.casus.demo.service.customer;

import casus.casus.demo.model.Customer;
import casus.casus.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    //POST / Create
    Customer saveObject(Customer object);
    //POST list / Create list
    List<Customer> saveObjects(List<Customer> objects);
    //GET ID / READ / Find by ID EASY
    Customer getObjectByID (Long id);
    //GET ByName/  Read
    Customer getByName(String name);
    //GET ALL / READ
    List<Customer> findAll();
    //UPDATE / PUT
    Customer checkIfExists(Customer object);
    //DELETE
    String deleteObject(long id);
}
