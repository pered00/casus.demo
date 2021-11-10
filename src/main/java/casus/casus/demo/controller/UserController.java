package casus.casus.demo.controller;

import casus.casus.demo.model.User;
import casus.casus.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService service;
    //POST / Create
    @PostMapping("/create")
    public ResponseEntity<User> addObject(@RequestBody User object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/create/list")
    public ResponseEntity<List<User>> addObjects(@RequestBody List<User>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public ResponseEntity<User> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }
    //GET ByName/  Read
    @GetMapping("/name/{name}")
    public ResponseEntity<User> findObjectByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.OK);
    }
    //GET ALL / READ
    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    //UPDATE / PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateObject(@RequestBody User object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
