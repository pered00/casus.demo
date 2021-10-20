package casus.casus.demo.repository;

import casus.casus.demo.model.PartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartItemRepository extends JpaRepository<PartItem, Long> {
    PartItem findByName(String Name);
}
