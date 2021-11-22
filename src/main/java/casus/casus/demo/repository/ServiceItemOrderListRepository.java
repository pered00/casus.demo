package casus.casus.demo.repository;

import casus.casus.demo.model.ServiceItemOrderJoinColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceItemOrderListRepository extends JpaRepository<ServiceItemOrderJoinColumn, Integer> {
    @Query(value = "SELECT * FROM service_item_order_list WHERE repair_order_id = :ID", nativeQuery = true)
    List<ServiceItemOrderJoinColumn> findAllByRepairOrderId(@Param("ID") Long repairOrderId);
    //uit sql een lijst halen van alle items die horen bij een order
}
