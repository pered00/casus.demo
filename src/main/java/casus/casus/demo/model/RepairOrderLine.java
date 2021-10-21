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
@Table(name="repair_order_line_tbl")
public class RepairOrderLine {
    @Id
    @SequenceGenerator(
            name = "repairOrderLine_sequence",
            sequenceName = "repairOrderLine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "repairOrderLine_sequence"
    )
    private long id;
    private String name;


}