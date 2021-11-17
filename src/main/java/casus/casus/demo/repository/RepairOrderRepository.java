package casus.casus.demo.repository;

import casus.casus.demo.model.OrderStatus;
import casus.casus.demo.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder, Long> {
        List<RepairOrder> findByStatus (OrderStatus status);
}
