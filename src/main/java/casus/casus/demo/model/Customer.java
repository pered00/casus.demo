package casus.casus.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table

public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String zipcode;
    private String city;
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicles;




}