package casus.casus.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PartItemID implements Serializable {

    @ManyToOne
    @JoinColumn(name = "part_item_id", referencedColumnName = "id")
    private PartItem partItem;
    @ManyToOne
    @JoinColumn(name = "repair_order_id", referencedColumnName = "id")
    private RepairOrder repairOrder;
}
