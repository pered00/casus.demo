package casus.casus.demo.service.customer;

import casus.casus.demo.model.Customer;
import casus.casus.demo.model.Customer;
import casus.casus.demo.repository.CustomerRepository;
import casus.casus.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;
    //POST / Create
    @Override
    public Customer saveObject(Customer object) {
        return repository.save(object);
    }
    //POST list / Create list
    @Override
    public List<Customer> saveObjects(List<Customer> objects) {
        return repository.saveAll(objects);
    }

    //GET ID / READ / Find by ID EASY
    @Override
    public Customer getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }
    //GET ByName/ READ
    @Override
    public Customer getByName(String name){
        return repository.findByName(name);
    }
    //GET ALL / READ
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }
    //UPDATE / PUT
    @Override
    public Customer checkIfExists (Customer object){
        if (Long.valueOf(object.getId()) != null){
            Optional<Customer> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new Customer();
            }
        }
        else{
            return saveObject(object);
        }
    }
    //DELETE
    @Override
    public String deleteObject(long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }
}
