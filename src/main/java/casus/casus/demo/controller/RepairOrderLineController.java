package casus.casus.demo.controller;

import casus.casus.demo.model.RepairOrderLine;
import casus.casus.demo.service.repairOrderLine.RepairOrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RepairOrderLine")
public class RepairOrderLineController {
    @Autowired
    RepairOrderLineService service;
    //POST / Create
    @PostMapping("/addRepairOrderLine")
    public ResponseEntity<RepairOrderLine> addObject(@RequestBody RepairOrderLine object){
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/addRepairOrderLines")
    public ResponseEntity<List<RepairOrderLine>> addObjects(@RequestBody List<RepairOrderLine>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public ResponseEntity<RepairOrderLine> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.FOUND);
    }
    //GET ByName/  Read
    @GetMapping("/name")
    public ResponseEntity<RepairOrderLine> findObjectByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.FOUND);
    }
    //GET ALL / READ
    @GetMapping("/RepairOrderLines")
    public ResponseEntity<List<RepairOrderLine>> findAllRepairOrderLines(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
    }
    //UPDATE / PUT
    @PutMapping("/update")
    public ResponseEntity<RepairOrderLine> updateObject(@RequestBody RepairOrderLine object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}

