package casus.casus.demo.controller;

import casus.casus.demo.dto.VehicleDTO;
import casus.casus.demo.model.Vehicle;
import casus.casus.demo.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Vehicle")
public class VehicleController {
    @Autowired
    VehicleService service;
    //POST / Create
    @PostMapping("/addVehicle")
    public ResponseEntity<Vehicle> addObject(@RequestBody Vehicle object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/addVehicles")
    public ResponseEntity<List<Vehicle>> addObjects(@RequestBody List<Vehicle>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
//    GET ID / READ Complete
//    @GetMapping("/{id}")
//    public VehicleDTO getVehicle(@PathVariable Long id){
//        return service.getByID(id); }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public Vehicle findObjectById(@PathVariable Long id){
        return service.getObjectByID(id);
    }
    //GET LicPlate / READ / Find by licPlate
    @GetMapping("/{licPlate}")
    public Vehicle findObjectByLicPlate(@PathVariable String licPlate){
        return service.getObjectBylicPlate(licPlate);
    }
    //GET ALL / READ
    @GetMapping("/Vehicles")
    public List<Vehicle> findAllVehicles(){
        return service.findAll();
    }
    //UPDATE / PUT
    @PutMapping("/update")
    public Vehicle updateObject(@RequestBody Vehicle object){
        return service.checkIfExists(object);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteObject(@RequestBody Long id){
        return service.deleteObject(id);
    }


}
