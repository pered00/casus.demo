package casus.casus.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class ServiceItemID implements Serializable {

    @ManyToOne
    @JoinColumn(name = "service_item_id", referencedColumnName = "id")
    private ServiceItem serviceItem;
    @ManyToOne
    @JoinColumn(name = "repair_order_id", referencedColumnName = "id")
    private RepairOrder repairOrder;
}
