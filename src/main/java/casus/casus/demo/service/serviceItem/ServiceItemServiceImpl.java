package casus.casus.demo.service.serviceItem;


import casus.casus.demo.model.ServiceItem;
import casus.casus.demo.repository.ServiceItemRepository;
import casus.casus.demo.service.serviceItem.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceItemServiceImpl implements ServiceItemService {

    @Autowired
    ServiceItemRepository repository;
    //POST / Create
    @Override
    public ServiceItem saveObject(ServiceItem object) {
        return repository.save(object);
    }
    //POST list / Create list
    @Override
    public List<ServiceItem> saveObjects(List<ServiceItem> objects) {
        return repository.saveAll(objects);
    }

    //GET ID / READ / Find by ID EASY
    @Override
    public ServiceItem getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }
    //GET ByName/ READ
    @Override
    public ServiceItem getByName(String name){
        return repository.findByName(name);
    }
    //GET ALL / READ
    @Override
    public List<ServiceItem> findAll() {
        return repository.findAll();
    }
    //UPDATE / PUT
    @Override
    public ServiceItem checkIfExists (ServiceItem object){
        if (Long.valueOf(object.getId()) != null){
            Optional<ServiceItem> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new ServiceItem();
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
