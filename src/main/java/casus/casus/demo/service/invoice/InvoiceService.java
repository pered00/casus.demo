package casus.casus.demo.service.invoice;

import casus.casus.demo.model.Invoice;
import java.util.List;

public interface InvoiceService {
    //POST / Create
    Invoice saveObject(Invoice object);
    //POST list / Create list
    List<Invoice> saveObjects(List<Invoice> objects);
    //GET ID / READ / Find by ID EASY
    Invoice getObjectByID (Long id);
    //GET ByName/  Read
    Invoice getByName(String name);
    //GET ALL / READ
    List<Invoice> findAll();
    //UPDATE / PUT
    Invoice checkIfExists(Invoice object);
    //DELETE
    String deleteObject(long id);
}