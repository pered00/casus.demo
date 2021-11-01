package casus.casus.demo.controller;

import casus.casus.demo.model.Document;
import casus.casus.demo.repository.DocumentRepository;
import casus.casus.demo.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class DocumentController {
    @Autowired
    DocumentService service;


    @GetMapping("/document")
    public String upload() {
        return "document.html";
    }

    @PostMapping("/document")
    @ResponseBody
    public String upload(@RequestParam(name="pdf") MultipartFile file, @RequestParam(name="licPlate")String licPlate) throws IOException {
        if (service.verifyIfLicPlateExists(licPlate)){
            return "this licPlate already exists";
        }
        else{
            service.saveDocument(file, licPlate);
            return "Document saved!";
        }
    }

    @GetMapping(value = "/document/{licPlate}", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] download(@PathVariable String licPlate) {
        Document document = service.getDocumentByLicPlate(licPlate);
        return document.content;
    }
}

