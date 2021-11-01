package casus.casus.demo.dto;

import casus.casus.demo.model.Vehicle;

import javax.persistence.OneToMany;
import java.util.List;

public class CustomerDTO {
    private Long id;
    private String name;
    private String address;
    private String zipcode;
    private String city;
    private String email;
    private List<Vehicle> vehicles;
}
