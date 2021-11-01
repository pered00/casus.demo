package casus.casus.demo.service.document;

import casus.casus.demo.model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocumentService {
    Document getDocumentByLicPlate(String licPlate);

    void saveDocument(MultipartFile file, String licPlate) throws IOException;
    boolean verifyIfLicPlateExists(String licPlate);
}
