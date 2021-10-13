package casus.casus.demo.service.vehicle;

import casus.casus.demo.dto.VehicleDTO;
import casus.casus.demo.dto.VehicleMapper;
import casus.casus.demo.model.Vehicle;
import casus.casus.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository repository;
    //POST / Create
    @Override
    public Vehicle saveObject(Vehicle object) {
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
    public Vehicle getObjectBylicPlate (String licPlate){
        return repository.findByLicPlate(licPlate);
    }
    //GET ALL / READ
    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }
    //UPDATE / PUT
    @Override
    public Vehicle checkIfExists (Vehicle object){
        if (Long.valueOf(object.getId()) != null){
            Optional<Vehicle> existingObject=repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new Vehicle();
            }
        }
        else{
            return saveObject(object);
        }
    }
    //DELETE
    @Override
    public String deleteObject(long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }
}
