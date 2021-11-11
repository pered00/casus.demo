package casus.casus.demo.service.vehicle;

import casus.casus.demo.model.Vehicle;

import java.util.List;

public interface VehicleService {
    //POST / Create
    Vehicle saveObject(Vehicle object, Long customerID);
    //POST list / Create list
    List<Vehicle> saveObjects(List<Vehicle> objects);
//    //GET ID / READ / Find by ID COMPLETE
//    VehicleDTO getByID(Long id);
    //GET ID / READ / Find by ID EASY
    Vehicle getObjectByID (Long id);
    //GET LicPlate / READ / Find by licPlate
    Vehicle getObjectBylicPlate (String licPlate);
    //GET ALL / READ
    List<Vehicle> findAll();
    //UPDATE / PUT
    Vehicle updateVehicle(Vehicle object);
    //DELETE
    String deleteObject(long id);
    //PUT relation
    void assignDocumentToVehicle(Long documentId, Long vehicleId);


}
