package casus.casus.demo.dto;

import casus.casus.demo.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private long id;
    private String licPlate;
    private Long documentId;
    private String brand;
    private String model;
    private Year buildYear;
    private int mileage;
    private Customer customer;


}
