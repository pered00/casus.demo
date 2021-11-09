package casus.casus.demo.service.repairOrderLine;

import casus.casus.demo.model.RepairOrder;
import casus.casus.demo.model.RepairOrderLine;

import java.util.List;

public interface RepairOrderLineService {
    //POST / Create
    RepairOrderLine saveObject(RepairOrderLine object);
    //POST list / Create list
    List<RepairOrderLine> saveObjects(List<RepairOrderLine> objects);
    //GET ID / READ / Find by ID EASY
    RepairOrderLine getObjectByID (Long id);
    //GET ALL / READ
    List<RepairOrderLine> findAll();
    //UPDATE / PUT
    RepairOrderLine checkIfExists(RepairOrderLine object);
    //DELETE
    String deleteObject(long id);
}
