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
    // Create (post)
    @PostMapping("/create")
    public ResponseEntity<Customer> addObject(@RequestBody Customer object){
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.CREATED);
       }
    //GET ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }
    //GET NAME
    @GetMapping("/name/{name}")
    public ResponseEntity<Customer> findObjectByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.OK);
    }
    //GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> findAllCustomers(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    //UPDATE (put)
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateObject(@RequestBody Customer object, @PathVariable Long id){
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
