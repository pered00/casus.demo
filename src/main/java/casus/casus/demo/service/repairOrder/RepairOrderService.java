package casus.casus.demo.service.repairOrder;

import casus.casus.demo.dto.RepairOrderDTO;
import casus.casus.demo.model.OrderStatus;
import casus.casus.demo.model.RepairOrder;
import java.util.List;

public interface RepairOrderService {
    //POST / Create
    RepairOrderDTO saveObject(RepairOrderDTO object);
    //POST list / Create list
    List<RepairOrder> saveObjects(List<RepairOrder> objects);
    //GET ID
    RepairOrderDTO getObjectByID (Long id);
    //GET ALL
    List<RepairOrder> findAll();
    //GET list By Status
    List<RepairOrder> getByStatus (OrderStatus status);
    //UPDATE
    RepairOrder checkIfExists(RepairOrder object);
    //DELETE
    String deleteObject(Long id);

}