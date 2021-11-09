package casus.casus.demo.service.repairOrder;

import casus.casus.demo.dto.RepairOrderDTO;
import casus.casus.demo.model.RepairOrder;
import java.util.List;

public interface RepairOrderService {
    //POST / Create
    RepairOrderDTO saveObject(RepairOrderDTO object);
    //POST list / Create list
    List<RepairOrder> saveObjects(List<RepairOrder> objects);
    //GET ID / READ / Find by ID EASY
    RepairOrder getObjectByID (Long id);
    //GET ALL / READ
    List<RepairOrder> findAll();
    //UPDATE / PUT
    RepairOrder checkIfExists(RepairOrder object);
    //DELETE
    String deleteObject(Long id);
}