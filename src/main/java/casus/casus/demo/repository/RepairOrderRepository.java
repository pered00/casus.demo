package casus.casus.demo.repository;

import casus.casus.demo.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder, Long> {
    RepairOrder findByName(String Name);
}
