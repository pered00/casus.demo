package casus.casus.demo.repository;

import casus.casus.demo.model.PartItemOrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartItemOrderListRepository extends JpaRepository<PartItemOrderList, Integer> {

}
