package casus.casus.demo.service.user;

import casus.casus.demo.model.User;
import java.util.List;

public interface UserService {
    //POST / Create
    User saveObject(User object);
    //POST list / Create list
    List<User> saveObjects(List<User> objects);
    //GET ID / READ / Find by ID EASY
    User getObjectByID (Long id);
    //GET ByName/  Read
    User getByName(String name);
    //GET ALL / READ
    List<User> findAll();
    //UPDATE / PUT
    User checkIfExists(User object);
    //DELETE
    String deleteObject(long id);
}