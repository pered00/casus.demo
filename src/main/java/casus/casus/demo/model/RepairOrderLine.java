package casus.casus.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="repair_order_line_tbl")
public class RepairOrderLine {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private RepairOrder repairOrder;

    @ManyToOne
    @JoinColumn(name= "usedItems", referencedColumnName = "id")
    private PartItem usedItems;
    @ManyToOne
    @JoinColumn(name= "usedServices", referencedColumnName = "id")
    private ServiceItem usedServices;


}