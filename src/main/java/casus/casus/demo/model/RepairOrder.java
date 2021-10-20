package casus.casus.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="repair_order_tbl")
public class RepairOrder {
    @Id
    @SequenceGenerator(
            name = "repairOrder_sequence",
            sequenceName = "repairOrder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "repairOrder_sequence"
    )
    private long id;
    private String name;


}