package casus.casus.demo.controller;

import casus.casus.demo.model.RepairOrder;
import casus.casus.demo.service.repairOrder.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RepairOrder")

public class RepairOrderController {
    @Autowired
    RepairOrderService service;
    //POST / Create
    @PostMapping("/addRepairOrder")
    public ResponseEntity<RepairOrder> addObject(@RequestBody RepairOrder object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/addRepairOrders")
    public ResponseEntity<List<RepairOrder>> addObjects(@RequestBody List<RepairOrder>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public ResponseEntity<RepairOrder> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.FOUND);
    }

    //GET ALL / READ
    @GetMapping("/RepairOrders")
    public ResponseEntity<List<RepairOrder>> findAllRepairOrders(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
    }
    //UPDATE / PUT
    @PutMapping("/update")
    public ResponseEntity<RepairOrder> updateObject(@RequestBody RepairOrder object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
