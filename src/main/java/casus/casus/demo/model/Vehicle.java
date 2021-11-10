package casus.casus.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="vehicle_tbl")
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @NotNull
    private String licPlate;
    private String brand;
    private String model;
    private Year buildYear;
    private int mileage;

    @OneToOne
    @JsonIgnore
    Document document;

    @ManyToOne
    @JsonIgnore
    private Customer customer;



}
