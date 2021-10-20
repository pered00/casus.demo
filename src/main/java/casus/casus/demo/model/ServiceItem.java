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
@Table(name="service_item_tbl")
public class ServiceItem {
    @Id
    @SequenceGenerator(
            name = "serviceItem_sequence",
            sequenceName = "serviceItem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "serviceItem_sequence"
    )
    private long id;
    private String name;
    //@Size(max = 500)
    private String description;
    private double sellingPrice;

}