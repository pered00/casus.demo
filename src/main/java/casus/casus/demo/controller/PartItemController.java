package casus.casus.demo.controller;

import casus.casus.demo.model.PartItem;
import casus.casus.demo.model.ServiceItem;
import casus.casus.demo.service.partItem.PartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PartItem")

public class PartItemController {
    @Autowired
    PartItemService service;
    //POST / Create
    @PostMapping("/addPartItem")
    public ResponseEntity<PartItem> addObject(@RequestBody PartItem object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/addPartItems")
    public ResponseEntity<List<PartItem>> addObjects(@RequestBody List<PartItem>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public ResponseEntity<PartItem> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.FOUND);
    }
    //GET ByName/  Read
    @GetMapping("/name")
    public ResponseEntity<PartItem> findObjectByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.FOUND);
    }
    //GET ALL / READ
    @GetMapping("/PartItems")
    public ResponseEntity<List<PartItem>> findAllPartItems(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
    }
    //UPDATE / PUT
    @PutMapping("/update")
    public ResponseEntity<PartItem> updateObject(@RequestBody PartItem object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
