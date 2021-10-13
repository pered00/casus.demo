package casus.casus.demo.model;

import javax.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private long id;
    private String name;
    private String function;
    private String email;


    //Constructors
    public Employee() {
    }

    public Employee(String name, String function, String email) {
        this.name = name;
        this.function = function;
        this.email = email;
    }

    // Getters / Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // To String
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + this.id +
                ", name='" + name + '\'' +
                ", function='" + function + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
