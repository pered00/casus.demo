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
@RequestMapping("/part")
public class PartItemController {
    @Autowired
    PartItemService service;
    //POST / Create
    @PostMapping("/create")
    public ResponseEntity<PartItem> addObject(@RequestBody PartItem object){
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/create/list")
    public ResponseEntity<List<PartItem>> addObjects(@RequestBody List<PartItem>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public ResponseEntity<PartItem> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }
    //GET ByName/  Read
    @GetMapping("/name/{name}")
    public ResponseEntity<PartItem> findObjectByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.OK);
    }
    //GET ALL / READ
    @GetMapping("/all")
    public ResponseEntity<List<PartItem>> findAllPartItems(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    //UPDATE / PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<PartItem> updateObject(@RequestBody PartItem object, @PathVariable Long id){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
