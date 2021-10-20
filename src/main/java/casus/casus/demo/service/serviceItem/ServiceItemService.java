package casus.casus.demo.service.serviceItem;

import casus.casus.demo.model.ServiceItem;
import java.util.List;

public interface ServiceItemService {
    //POST / Create
    ServiceItem saveObject(ServiceItem object);
    //POST list / Create list
    List<ServiceItem> saveObjects(List<ServiceItem> objects);
    //GET ID / READ / Find by ID EASY
    ServiceItem getObjectByID (Long id);
    //GET ByName/  Read
    ServiceItem getByName(String name);
    //GET ALL / READ
    List<ServiceItem> findAll();
    //UPDATE / PUT
    ServiceItem checkIfExists(ServiceItem object);
    //DELETE
    String deleteObject(long id);
}