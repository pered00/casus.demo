package casus.casus.demo.service;

import casus.casus.demo.model.Customer;
import casus.casus.demo.model.Employee;
import casus.casus.demo.repository.CustomerRepository;
import casus.casus.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee changeEmployee(Employee employee) {
        return null;
    }
}
