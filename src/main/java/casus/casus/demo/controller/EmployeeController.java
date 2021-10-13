package casus.casus.demo.controller;

import casus.casus.demo.model.Customer;
import casus.casus.demo.model.Employee;
import casus.casus.demo.service.CustomerService;
import casus.casus.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping  //id heeft betrekking op een enkel object.
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }


    @PostMapping
    public ResponseEntity<Employee> registerNewEmployee (@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addNewEmployee(employee), HttpStatus.CREATED) ;
    }



}