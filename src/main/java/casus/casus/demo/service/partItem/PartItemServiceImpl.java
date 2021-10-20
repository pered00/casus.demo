package casus.casus.demo.service.partItem;

import casus.casus.demo.model.PartItem;
import casus.casus.demo.repository.PartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartItemServiceImpl implements PartItemService {

    @Autowired
    PartItemRepository repository;
    //POST / Create
    @Override
    public PartItem saveObject(PartItem object) {
        return repository.save(object);
    }
    //POST list / Create list
    @Override
    public List<PartItem> saveObjects(List<PartItem> objects) {
        return repository.saveAll(objects);
    }

    //GET ID / READ / Find by ID EASY
    @Override
    public PartItem getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }
    //GET ByName/ READ
    @Override
    public PartItem getByName(String name){
        return repository.findByName(name);
    }
    //GET ALL / READ
    @Override
    public List<PartItem> findAll() {
        return repository.findAll();
    }
    //UPDATE / PUT
    @Override
    public PartItem checkIfExists (PartItem object){
        if (Long.valueOf(object.getId()) != null){
            Optional<PartItem> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new PartItem();
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
