package casus.casus.demo.service.vehicle;


import casus.casus.demo.dto.VehicleDTO;
import casus.casus.demo.exception.RecordNotFoundException;
import casus.casus.demo.model.Customer;
import casus.casus.demo.model.Vehicle;
import casus.casus.demo.repository.CustomerRepository;
import casus.casus.demo.repository.DocumentRepository;
import casus.casus.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    VehicleRepository repository;
    DocumentRepository documentRepository;
    @Autowired
    CustomerRepository customerRepository;
    //POST / Create
    // Before creating Vehicle, check if Customer exists. If not use exception to return error, customer must be created first
    @Override
    public Vehicle saveObject(Vehicle object, Long customerID) {
        Optional<Customer> checkIfCustomerExists = customerRepository.findById(customerID);
        if (checkIfCustomerExists.isPresent()){
            object.setCustomer(checkIfCustomerExists.get());
        }
        else {
            return null;
        }
        return repository.save(object);
            }
    //POST list / Create list
    @Override
    public List<Vehicle> saveObjects(List<Vehicle> objects) {
        return repository.saveAll(objects);
    }
//    //GET ID / READ / Find by ID
//    @Override
//    public VehicleDTO getByID(Long id) {
//        Vehicle vehicle= repository.findById(id).get();
//        VehicleDTO varDTO= VehicleMapper.createDTOFromEntity(vehicle);
//        return varDTO;
    //GET ID / READ / Find by ID EASY
    public Vehicle getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }
    //GET LicPlate / READ / Find by licPlate
    public VehicleDTO getObjectBylicPlate (String licPlate){
        Vehicle v= repository.findByLicPlate(licPlate);
        VehicleDTO v2= new VehicleDTO(
                v.getId(),
                v.getLicPlate(),
                v.getDocument().getId(),
                v.getBrand(),
                v.getModel(),
                v.getBuildYear(),
                v.getMileage(),
                v.getCustomer()
        );
        return v2;
    }
    //    GET ALL / READ
    @Override
    public List<VehicleDTO> findAll() {
        List<Vehicle> vlist = repository.findAll();
        List<VehicleDTO> dList = new ArrayList<>();
        vlist.forEach(vehicle -> {
            VehicleDTO dto = new VehicleDTO();
            dto.setId(vehicle.getId());
            dto.setLicPlate(vehicle.getLicPlate());
            dto.setDocumentId(vehicle.getDocument().getId());
            dList.add(dto);
        });
        return dList;
    }


    //UPDATE / PUT
    @Override
    public Vehicle updateVehicle (Vehicle object) {
        if (object.getId() != null) {
            Optional<Vehicle> existingObject = repository.findById(object.getId());
            if (existingObject.isPresent()) {
                return repository.save(object);
            } else {
                return null;
            }
        }
        return null;
    }
    //DELETE
    @Override
    public String deleteObject(long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }
    //PUT
    @Override
    public void assignDocumentToVehicle(Long documentId, Long vehicleId) {
        var optionalDocument = documentRepository.findById(documentId);
        var optionalVehicle = repository.findById(vehicleId);
        if (optionalDocument.isPresent() && optionalVehicle.isPresent()) {
            var document = optionalDocument.get();
            var vehicle = optionalVehicle.get();
            vehicle.setDocument(document);
            repository.save(vehicle);
        } else {
            throw new RecordNotFoundException("Vehicle or document is not found");
        }
    }
}
