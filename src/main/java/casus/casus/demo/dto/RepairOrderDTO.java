package casus.casus.demo.dto;

import casus.casus.demo.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepairOrderDTO {

    private Long id;
    private String status;
    private LocalDate startDate;
    private LocalDate inspectionDate;
    private LocalDate repairDate;
    private String findings;
    private String agreementNotes;
    private Customer customer;
    private Vehicle vehicle;
    private List<PartItem> usedItems;
    private List<ServiceItem> usedServices;



}
