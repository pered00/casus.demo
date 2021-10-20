package casus.casus.demo.service.repairOrder;

import casus.casus.demo.model.RepairOrder;
import java.util.List;

public interface RepairOrderService {
    //POST / Create
    RepairOrder saveObject(RepairOrder object);
    //POST list / Create list
    List<RepairOrder> saveObjects(List<RepairOrder> objects);
    //GET ID / READ / Find by ID EASY
    RepairOrder getObjectByID (Long id);
    //GET ByName/  Read
    RepairOrder getByName(String name);
    //GET ALL / READ
    List<RepairOrder> findAll();
    //UPDATE / PUT
    RepairOrder checkIfExists(RepairOrder object);
    //DELETE
    String deleteObject(long id);
}