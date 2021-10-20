package casus.casus.demo.service.invoice;

import casus.casus.demo.model.Invoice;
import casus.casus.demo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository repository;
    //POST / Create
    @Override
    public Invoice saveObject(Invoice object) {
        return repository.save(object);
    }
    //POST list / Create list
    @Override
    public List<Invoice> saveObjects(List<Invoice> objects) {
        return repository.saveAll(objects);
    }

    //GET ID / READ / Find by ID EASY
    @Override
    public Invoice getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }
    //GET ByName/ READ
    @Override
    public Invoice getByName(String name){
        return repository.findByName(name);
    }
    //GET ALL / READ
    @Override
    public List<Invoice> findAll() {
        return repository.findAll();
    }
    //UPDATE / PUT
    @Override
    public Invoice checkIfExists (Invoice object){
        if (Long.valueOf(object.getId()) != null){
            Optional<Invoice> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new Invoice();
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
