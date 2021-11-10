package casus.casus.demo.controller;

import casus.casus.demo.dto.VehicleDTO;
import casus.casus.demo.model.Vehicle;
import casus.casus.demo.service.vehicle.VehicleService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService service;

    // Create (post)
    // * Before creating Vehicle, check if Customer exists.
    // * If not use exception to return error, customer must be created first
    @PostMapping("/create/{customerID}")
    public ResponseEntity<?> addObject(@RequestBody Vehicle object, @PathVariable Long customerID){
        Vehicle vehicle = service.saveObject(object, customerID);
        if (vehicle != null){
            return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("CustomerID not found, customer must be created before vehicle", HttpStatus.NOT_FOUND);
        }
    }
    //GET ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Vehicle> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }
    //GET LicPlate
    @GetMapping("/licPlate/{licPlate}")
    public ResponseEntity<Vehicle>findObjectByLicPlate(@PathVariable String licPlate){
        return  new ResponseEntity<>(service.getObjectBylicPlate(licPlate),HttpStatus.OK);
    }
    //GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> findAllVehicles(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    //UPDATE / PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateObject(@RequestBody Vehicle object, @PathVariable Long id){
        return new ResponseEntity<>(service.updateVehicle(object), HttpStatus.OK);

    }
        /*
        Vehicle vehicle = service.updateVehicle(object);
        if (vehicle != null){
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("VehicleID doesn't exists, Vehicle update not possible", HttpStatus.NOT_FOUND);
        }
    }

         */
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }

    //Assign Document to Vehicle
    @PutMapping("{id}/document")
    public void assignDocumentToVehicle(@PathVariable("id")Long vehicleId, @RequestBody Long documentId) {
        service.assignDocumentToVehicle(documentId, vehicleId);
    }

}
