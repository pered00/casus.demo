package casus.casus.demo.controller;

import casus.casus.demo.model.Customer;
import casus.casus.demo.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/customers")
public class CustomerController {

   //reference to CustomerService
    private final CostumerService costumerService;

    //Constructor with Dependency Injection from Service (Autowired = customerService variable will be instantiated automatically)
    @Autowired
    public CustomerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping () //"/getCustomers"
    public List<Customer> getCustomers() {
        return costumerService.getCustomers();
        }

    @PostMapping
    public ResponseEntity<Customer> registerNewCustomer (@RequestBody Customer customer) {
        return new ResponseEntity<>(costumerService.addNewCustomer(customer), HttpStatus.CREATED) ;
        }


}
