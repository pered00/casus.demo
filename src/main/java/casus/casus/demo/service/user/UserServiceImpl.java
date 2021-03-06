package casus.casus.demo.service.user;

import casus.casus.demo.model.User;
import casus.casus.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
    //POST / Create
    @Override
    public User saveObject(User object) {
        BCryptPasswordEncoder password= new BCryptPasswordEncoder();
        object.setPassword(password.encode(object.getPassword()));
        return repository.save(object);
    }
    //POST list / Create list
    @Override
    public List<User> saveObjects(List<User> objects) {
        return repository.saveAll(objects);
    }

    //GET ID / READ / Find by ID EASY
    @Override
    public User getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }
    //GET ByName/ READ
    @Override
    public User getByName(String name){
        return repository.findByName(name);
    }
    //GET ALL / READ
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
    //UPDATE / PUT
    @Override
    public User checkIfExists (User object){
        if (object.getId() != null){
            Optional<User> existingObject= repository.findById(object.getId());
            if (existingObject.isPresent()){
                return saveObject(object);
            }
            else{
                return new User();
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
