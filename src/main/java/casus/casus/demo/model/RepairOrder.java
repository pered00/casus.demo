package casus.casus.demo.model;

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
@Entity
@Table(name="repair_order_tbl")
public class RepairOrder {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate startDate;
    private LocalDate inspectionDate;
    private LocalDate repairDate;
    private String findings;
    @Lob
    private String agreementNotes;
    @OneToOne
    private Customer customer;
    @OneToOne
    Vehicle vehicle;
    @OneToMany
    private List<PartItemOrderList> usedItems;
    @OneToMany
    private List<ServiceItemOrderList> usedServices;




}