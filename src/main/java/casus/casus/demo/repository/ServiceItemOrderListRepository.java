package casus.casus.demo.repository;

import casus.casus.demo.model.ServiceItemOrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceItemOrderListRepository extends JpaRepository<ServiceItemOrderList, Integer> {

}
