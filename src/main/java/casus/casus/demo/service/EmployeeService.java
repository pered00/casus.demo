package casus.casus.demo.service;

import casus.casus.demo.model.Customer;
import casus.casus.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployee();
    public Employee addNewEmployee( Employee employee);
    public Employee changeEmployee( Employee employee);




}
//    omschrijven van methode + functie
//    GET
//    GET-ALL
//    POST
//    PUT
//    DELETE