package casus.casus.demo.service.userRole;

import casus.casus.demo.model.UserRole;
import casus.casus.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    UserRoleRepository repository;

    //POST / Create
    @Override
    public UserRole saveObject(UserRole object) {
        return repository.save(object);
    }

    //GET ALL / READ
    public List<UserRole> findAll(){
        return repository.findAll();
    }


}
