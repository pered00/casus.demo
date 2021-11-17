package casus.casus.demo.controller;

import casus.casus.demo.dto.RepairOrderDTO;
import casus.casus.demo.model.OrderStatus;
import casus.casus.demo.model.RepairOrder;
import casus.casus.demo.service.repairOrder.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")

public class RepairOrderController {
    @Autowired
    RepairOrderService service;
    //POST / Create
    @PostMapping("/create")
    public ResponseEntity<RepairOrderDTO> addObject(@RequestBody RepairOrderDTO object){
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/create/list")
    public ResponseEntity<List<RepairOrder>> addObjects(@RequestBody List<RepairOrder>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.OK);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public ResponseEntity<RepairOrderDTO> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }

    //GET ALL / READ
    @GetMapping("/all")
    public ResponseEntity<List<RepairOrder>> findAllRepairOrders(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    //GET by Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<RepairOrder>> getByStatus(@PathVariable OrderStatus status) {
        return new ResponseEntity<List<RepairOrder>>(service.getByStatus(status), HttpStatus.OK);
    }

    //UPDATE / PUT
    @PutMapping(path="/update")
    public ResponseEntity<RepairOrderDTO> updateObject(@RequestBody RepairOrderDTO object){
        return new ResponseEntity<>(service.saveObject(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
