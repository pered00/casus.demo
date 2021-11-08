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
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private double sellingPrice;

}