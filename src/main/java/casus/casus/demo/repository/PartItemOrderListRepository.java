package casus.casus.demo.repository;

import casus.casus.demo.model.PartItemOrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartItemOrderListRepository extends JpaRepository<PartItemOrderList, Integer> {

    @Query(value = "SELECT * FROM part_item_order_list WHERE repair_order_id = :ID", nativeQuery = true)
    List<PartItemOrderList> findAllByRepairOrderId(@Param("ID") Long repairOrderId);
}
