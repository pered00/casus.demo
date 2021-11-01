package casus.casus.demo.repository;

import casus.casus.demo.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Document findByLicPlate(String licPlate);
}
