package casus.casus.demo.controller;

import casus.casus.demo.model.PartItem;
import casus.casus.demo.model.UserRole;
import casus.casus.demo.service.userRole.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class UserRoleController {
    @Autowired
    UserRoleService service;

    //POST / Create
    @PostMapping("/create")
    public ResponseEntity<UserRole> addObject(@RequestBody UserRole object) {
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.CREATED);
    }

    //GET ALL / READ
    @GetMapping("/all")
    public ResponseEntity<List<UserRole>> findAllPartItems(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
