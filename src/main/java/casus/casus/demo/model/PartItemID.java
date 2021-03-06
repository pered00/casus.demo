package casus.casus.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class PartItemID implements Serializable {

    //alle velden zijn key van PartItmeOrderList table. @Embeddable zorgt dat deze hiervoor gebruikt wordt.
    @ManyToOne
    @JoinColumn(name = "part_item_id", referencedColumnName = "id")
    private PartItem partItem;
    @ManyToOne
    @JoinColumn(name = "repair_order_id", referencedColumnName = "id")
    private RepairOrder repairOrder;
}
