package casus.casus.demo.service.partItem;

import casus.casus.demo.model.PartItem;
import java.util.List;

public interface PartItemService {
    //POST / Create
    PartItem saveObject(PartItem object);
    //POST list / Create list
    List<PartItem> saveObjects(List<PartItem> objects);
    //GET ID / READ / Find by ID EASY
    PartItem getObjectByID (Long id);
    //GET ByName/  Read
    PartItem getByName(String name);
    //GET ALL / READ
    List<PartItem> findAll();
    //UPDATE / PUT
    PartItem checkIfExists(PartItem object);
    //DELETE
    String deleteObject(long id);
}