package casus.casus.demo.service.userRole;

import casus.casus.demo.model.UserRole;
import org.springframework.stereotype.Service;
import java.util.List;


public interface UserRoleService {

    //POST / Create
    UserRole saveObject(UserRole object);

    //GET ALL / READ
    List<UserRole> findAll();


}
