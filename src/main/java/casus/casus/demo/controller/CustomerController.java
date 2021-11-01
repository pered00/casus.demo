package casus.casus.demo.controller;

import casus.casus.demo.model.Customer;
import casus.casus.demo.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/customer")
public class CustomerController {

    @Autowired
    CustomerService service;
    //POST / Create
    @PostMapping("/create")
    public ResponseEntity<Customer> addObject(@RequestBody Customer object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/create/list")
    public ResponseEntity<List<Customer>> addObjects(@RequestBody List<Customer>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }
    //GET ByName/  Read
    @GetMapping("/name")
    public ResponseEntity<Customer> findObjectByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.OK);
    }
    //GET ALL / READ
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAllCustomers(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    //UPDATE / PUT
    @PutMapping("/update")
    public ResponseEntity<Customer> updateObject(@RequestBody Customer object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
