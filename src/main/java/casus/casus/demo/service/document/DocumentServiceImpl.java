package casus.casus.demo.service.document;

import casus.casus.demo.model.Document;
import casus.casus.demo.model.Vehicle;
import casus.casus.demo.repository.DocumentRepository;
import casus.casus.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private  DocumentRepository repository;
    @Autowired
    private VehicleRepository vRepository;

    @Override
    public Document getDocumentByLicPlate(String licPlate) {
        return repository.findByLicPlate(licPlate);
    }

    @Override
    public void saveDocument(MultipartFile file, String licPlate) throws IOException {
        Document document = new Document();
        document.setLicPlate(licPlate);
        document.content = file.getBytes();
        document=repository.save(document);
        pairDocumentVehicle(licPlate,document);
    }

    private void pairDocumentVehicle(String licPlate, Document document){
        Vehicle v=vRepository.findByLicPlate(licPlate);
        v.setDocument(document);
        vRepository.save(v);
    }
    @Override
    public boolean verifyIfLicPlateExists(String licPlate){
        Document document= repository.findByLicPlate(licPlate);
        if (document != null){
            return true;
        }
        else {
            return false;
        }
    }


}
