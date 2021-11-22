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
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDate startDate;
    private LocalDate inspectionDate;
    private LocalDate repairDate;
    private String findings;
    @Lob
    private String agreementNotes;
    @OneToOne
    private Customer customer;
    private Double totalPriceExTax;
    private Double totalPriceInTax;

    private Double totalTaxAmount;


    @OneToOne
    private Vehicle vehicle;
    @OneToMany(mappedBy = "id.partItem")
    private List<PartItemOrderJoinColumn> usedItems;
    @OneToMany(mappedBy = "id.serviceItem")
    private List<ServiceItemOrderJoinColumn> usedServices;




}