package casus.casus.demo.repository;

import casus.casus.demo.model.RepairOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepairOrderLineRepository extends JpaRepository<RepairOrderLine, Long> {
    RepairOrderLine findByName(String Name);
}