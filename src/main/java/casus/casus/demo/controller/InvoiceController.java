package casus.casus.demo.controller;

import casus.casus.demo.model.Invoice;
import casus.casus.demo.service.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")

public class InvoiceController {
    @Autowired
    InvoiceService service;
    //POST / Create
    @PostMapping("/create")
    public ResponseEntity<Invoice> addObject(@RequestBody Invoice object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/create/list")
    public ResponseEntity<List<Invoice>> addObjects(@RequestBody List<Invoice>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.OK);
    }
    //GET ALL / READ
    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> findAllInvoices(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    //UPDATE / PUT
    @PutMapping("/update")
    public ResponseEntity<Invoice> updateObject(@RequestBody Invoice object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.OK);
    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteObject(@RequestBody Long id){
        return new ResponseEntity<>(service.deleteObject(id), HttpStatus.OK);
    }
}
