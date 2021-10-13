package casus.casus.demo.controller;

import casus.casus.demo.model.Customer;
import casus.casus.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/customers")
public class CustomerController {

   //reference to CustomerService
    private final CustomerService customerService;

    //Constructor with Dependency Injection from Service (Autowired = customerSer
    // vice variable will be instantiated automatically)
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping  //id heeft betrekking op een enkel object.
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
        }


    @PostMapping
    public ResponseEntity<Customer> registerNewCustomer (@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addNewCustomer(customer), HttpStatus.CREATED) ;
        }


}
