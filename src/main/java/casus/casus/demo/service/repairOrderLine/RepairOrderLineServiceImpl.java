package casus.casus.demo.service.repairOrderLine;

import casus.casus.demo.model.RepairOrderLine;
import casus.casus.demo.repository.RepairOrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairOrderLineServiceImpl implements RepairOrderLineService {

    @Autowired
    RepairOrderLineRepository repository;
    //POST / Create
    @Override
    public RepairOrderLine saveObject(RepairOrderLine object) {
        return repository.save(object);
    }

    //POST list / Create list
    @Override
    public List<RepairOrderLine> saveObjects(List<RepairOrderLine> objects) {
        return repository.saveAll(objects);
    }

    //GET ID / READ / Find by ID EASY
    @Override
    public RepairOrderLine getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }

    //GET ALL / READ
    @Override
    public List<RepairOrderLine> findAll() {
        return repository.findAll();
    }

    //UPDATE / PUT
    @Override
    public RepairOrderLine checkIfExists (RepairOrderLine object){
        if (Long.valueOf(object.getId()) != null){
            Optional<RepairOrderLine> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new RepairOrderLine();
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
