package casus.casus.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ServiceItemOrderList {
    @EmbeddedId
    private ServiceItemID serviceItemID;
}
