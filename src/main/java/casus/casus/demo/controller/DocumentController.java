package casus.casus.demo.controller;

import casus.casus.demo.model.Document;
import casus.casus.demo.repository.DocumentRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class DocumentController {

    private final DocumentRepository repos;

    public DocumentController(DocumentRepository repos) {
        this.repos = repos;
    }

    @GetMapping("/document")
    public String upload() {
        return "document.html";
    }

    @PostMapping("/document")
    @ResponseBody
    public String upload(@RequestParam(name="document") MultipartFile file) throws IOException {
        Document document = new Document();
        document.content = file.getBytes();
        repos.save(document);
        return "Document saved!";
    }

    @GetMapping(value = "/document/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] download(@PathVariable Long id) {
        Document document = repos.findById(id).get();
        return document.content;
    }
}

