package casus.casus.demo.controller;


import casus.casus.demo.model.ServiceItem;
import casus.casus.demo.service.serviceItem.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")

public class ServiceItemController {
    @Autowired
    ServiceItemService service;
    //POST / Create
    @PostMapping("/create")
    public ResponseEntity<ServiceItem> addObject(@RequestBody ServiceItem object){
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/create/list")
    public ResponseEntity<List<ServiceItem>> addObjects(@RequestBody List<ServiceItem>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public ResponseEntity<ServiceItem> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.FOUND);
    }
    //GET ByName/  Read
    @GetMapping("/name/{name}")
    public ResponseEntity<ServiceItem> findObjectByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.FOUND);
    }
    //GET ALL / READ
    @GetMapping("/all")
    public ResponseEntity<List<ServiceItem>> findAllServiceItems(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
    }
    //UPDATE / PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceItem> updateObject(@RequestBody ServiceItem object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
