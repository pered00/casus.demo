package casus.casus.demo.service.repairOrder;

import casus.casus.demo.dto.RepairOrderDTO;
import casus.casus.demo.model.PartItemOrderList;
import casus.casus.demo.model.RepairOrder;
import casus.casus.demo.model.ServiceItemOrderList;
import casus.casus.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairOrderServiceImpl implements RepairOrderService {

    @Autowired
    RepairOrderRepository repository;
    @Autowired
    PartItemOrderListRepository partItemOrderListRepository;
    @Autowired
    ServiceItemOrderListRepository serviceItemOrderListRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    VehicleRepository vehicleRepository;


    //POST / Create
    @Override
    public RepairOrderDTO saveObject(RepairOrderDTO object) {
        object.setCustomer(customerRepository.findById(object.getCustomer().getId()).get());
        object.setVehicle(vehicleRepository.findById(object.getVehicle().getId()).get());
        RepairOrder repairOrder = new RepairOrder();
        repairOrder.setStartDate(object.getStartDate());
        repairOrder.setStatus(object.getStatus());
        repairOrder.setInspectionDate(object.getInspectionDate());
        repairOrder.setRepairDate(object.getRepairDate());
        repairOrder.setFindings(object.getFindings());
        repairOrder.setAgreementNotes(object.getAgreementNotes());
        repairOrder.setCustomer(object.getCustomer());
        repairOrder.setVehicle(object.getVehicle());

        repairOrder = repository.save(repairOrder);
        object.setId(repairOrder.getId());

        final RepairOrder r = repairOrder;
        if(object.getUsedItems().size()>0){
            object.getUsedItems().forEach(obj -> {
                PartItemOrderList partItemOrderList = new PartItemOrderList();
                partItemOrderList.getId().setPartItem(obj);
                partItemOrderList.getId().setRepairOrder(r);

                partItemOrderListRepository.save(partItemOrderList);
            });
        }

        if(object.getUsedServices().size()>0) {
            object.getUsedServices().forEach(obj -> {
                ServiceItemOrderList serviceItemOrderList = new ServiceItemOrderList();
                serviceItemOrderList.getId().setServiceItem(obj);
                serviceItemOrderList.getId().setRepairOrder(r);
                serviceItemOrderListRepository.save(serviceItemOrderList);
            });
        }
        return object;
    }
    //POST list / Create list
    @Override
    public List<RepairOrder> saveObjects(List<RepairOrder> objects) {
        return repository.saveAll(objects);
    }

    //GET ID / READ / Find by ID EASY
    @Override
    public RepairOrder getObjectByID (Long id){
        return repository.findById(id).orElse(null);
    }

    //GET ALL / READ
    @Override
    public List<RepairOrder> findAll() {
        return repository.findAll();
    }
    //UPDATE / PUT
    @Override
    public RepairOrder checkIfExists (RepairOrder object){
        return null;
//        if (Long.valueOf(object.getId()) != null){
//            Optional<RepairOrder> existingObject= repository.findById(object.getId());
//            if (existingObject.isPresent()){
//                return saveObject(object);
//            }
//            else{
//                return new RepairOrder();
//            }
//        }
//        else{
//            return saveObject(object);
//        }
    }
    //DELETE
    @Override
    public String deleteObject(Long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }
}
