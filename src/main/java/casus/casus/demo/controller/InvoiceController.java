package casus.casus.demo.controller;

import casus.casus.demo.model.Invoice;
import casus.casus.demo.service.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Invoice")

public class InvoiceController {
    @Autowired
    InvoiceService service;
    //POST / Create
    @PostMapping("/addInvoice")
    public ResponseEntity<Invoice> addObject(@RequestBody Invoice object){
        return new ResponseEntity<>(service.checkIfExists(object), HttpStatus.CREATED);
    }
    //POST list / Create list
    @PostMapping("/addInvoices")
    public ResponseEntity<List<Invoice>> addObjects(@RequestBody List<Invoice>objects) {
        return new ResponseEntity<>(service.saveObjects(objects), HttpStatus.CREATED);
    }
    //GET ID / READ / Find by ID EASY
    @GetMapping("/id/{id}")
    public ResponseEntity<Invoice> findObjectById(@PathVariable Long id){
        return new ResponseEntity<>(service.getObjectByID(id), HttpStatus.FOUND);
    }
    //GET ByName/  Read
    @GetMapping("/name")
    public ResponseEntity<Invoice> findObjectByName(@PathVariable String name){
        return new ResponseEntity<>(service.getByName(name),HttpStatus.FOUND);
    }
    //GET ALL / READ
    @GetMapping("/Invoices")
    public ResponseEntity<List<Invoice>> findAllInvoices(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
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
