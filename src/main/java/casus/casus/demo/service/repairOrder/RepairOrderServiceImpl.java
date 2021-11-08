package casus.casus.demo.service.repairOrder;

import casus.casus.demo.model.RepairOrder;
import casus.casus.demo.repository.RepairOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairOrderServiceImpl implements RepairOrderService {

    @Autowired
    RepairOrderRepository repository;
    //POST / Create
    @Override
    public RepairOrder saveObject(RepairOrder object) {
        return repository.save(object);
    }
    //POST list / Create list
    @Override
    public List<RepairOrder> saveObjects(List<RepairOrder> objects) {
        return repository.saveAll(objects);
    }

    //GET ID / READ / Find by ID EASY
    @Override
    public RepairOrder getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }
    //GET ByName/ READ
    @Override
    public RepairOrder getByName(String name){
        return repository.findByName(name);
    }
    //GET ALL / READ
    @Override
    public List<RepairOrder> findAll() {
        return repository.findAll();
    }
    //UPDATE / PUT
    @Override
    public RepairOrder checkIfExists (RepairOrder object){
        if (Long.valueOf(object.getId()) != null){
            Optional<RepairOrder> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new RepairOrder();
            }
        }
        else{
            return saveObject(object);
        }
    }
    //DELETE
    @Override
    public String deleteObject(Long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }
}
