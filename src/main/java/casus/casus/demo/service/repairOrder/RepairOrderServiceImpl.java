package casus.casus.demo.service.repairOrder;

import casus.casus.demo.dto.RepairOrderDTO;
import casus.casus.demo.model.*;
import casus.casus.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    // DTO omdat  in repairorder heeft [] partitemsorderlist, kan niet in database, partItemOrderList is een tussentabel, multi foringkey/

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

        if (object.getId() != null){
            repairOrder.setId(object.getId());
        }
        repairOrder = repository.save(repairOrder);
        object.setId(repairOrder.getId());

        final RepairOrder r = repairOrder;
        object.getUsedItems().forEach(obj -> {
            PartItemOrderList partItemOrderList = new PartItemOrderList();
            PartItemID partItemID = new PartItemID();

            partItemID.setPartItem(obj);
            partItemID.setRepairOrder(r);

            partItemOrderList.setId(partItemID);

            partItemOrderListRepository.save(partItemOrderList);
        });

        object.getUsedServices().forEach(obj ->{
            ServiceItemOrderList serviceItemOrderList = new ServiceItemOrderList();
            ServiceItemID serviceItemID = new ServiceItemID();

            serviceItemID.setServiceItem(obj);
            serviceItemID.setRepairOrder(r);

            serviceItemOrderList.setId(serviceItemID);

            serviceItemOrderListRepository.save(serviceItemOrderList);
        });
                return object;
    }
    //POST list / Create list
    @Override
    public List<RepairOrder> saveObjects(List<RepairOrder> objects) {
        return repository.saveAll(objects);
    }

    //GET ID
    @Override
    public RepairOrderDTO getObjectByID (Long id){
        final Double taxRate = 1.21;

        RepairOrder repairOrder = repository.findById(id).orElse(null);
        RepairOrderDTO repairOrderDTO = new RepairOrderDTO();
        repairOrderDTO.setId(repairOrder.getId());
        repairOrderDTO.setCustomer(repairOrder.getCustomer());
        repairOrderDTO.setVehicle(repairOrder.getVehicle());
        repairOrderDTO.setStartDate(repairOrder.getStartDate());
        repairOrderDTO.setStatus(repairOrder.getStatus());
        repairOrderDTO.setInspectionDate(repairOrder.getInspectionDate());
        repairOrderDTO.setRepairDate(repairOrder.getRepairDate());
        repairOrderDTO.setFindings(repairOrder.getFindings());
        repairOrderDTO.setAgreementNotes(repairOrder.getAgreementNotes());

        List<PartItemOrderList> partItemOrderList = getListRepairOrderItems(repairOrder.getId());
        List<PartItem> partItemsList = getListPartItem(partItemOrderList);
        repairOrderDTO.setUsedItems(partItemsList);

        repairOrderDTO.setUsedServices(getListServiceItem(getListRepairOrderServices(repairOrder.getId())));

        Double totalItems = getTotalItems(repairOrderDTO.getUsedItems());
        Double totalServices = getTotalServices(repairOrderDTO.getUsedServices());

        repairOrderDTO.setTotalPriceInTax((totalItems + totalServices) * taxRate);
        repairOrderDTO.setTotalPriceExTax(totalItems + totalServices);
        repairOrderDTO.setTotalTaxAmount(repairOrderDTO.getTotalPriceInTax()-repairOrderDTO.getTotalPriceExTax());
        return repairOrderDTO;
    }

    //haalt lijst van partItem uit SQL via repository
    private List<PartItemOrderList> getListRepairOrderItems(Long repairOrderId){
        List<PartItemOrderList> listPartItemOrder = partItemOrderListRepository.findAllByRepairOrderId(repairOrderId);
        return listPartItemOrder;
    }

    private  List<ServiceItemOrderList> getListRepairOrderServices(Long repairOrderId){
        List<ServiceItemOrderList> serviceItemOrderList = serviceItemOrderListRepository.findAllByRepairOrderId(repairOrderId);
        return serviceItemOrderList;
    }

    //vertaalt de tabel uit SQL naar een lijst met partItems objecten
    private List<PartItem> getListPartItem(List<PartItemOrderList> partItemOrderList){
        List<PartItem> listPartItems = new ArrayList<>();

        partItemOrderList.forEach(obj -> {
            listPartItems.add(obj.getId().getPartItem());
        });

        return listPartItems;
    }

    private List<ServiceItem> getListServiceItem(List<ServiceItemOrderList> serviceItemOrderList){
        List<ServiceItem> listServiceItem = new ArrayList<>();

        serviceItemOrderList.forEach(obj -> {
            listServiceItem.add(obj.getId().getServiceItem());
        });

        return listServiceItem;
    }
    //totaalprijs berekenen van de aantal item in lijst
    private Double getTotalItems(List<PartItem> usedItems) {
        Double total = 0.0;

        for(PartItem obj: usedItems) {
            total += obj.getSellingPrice();
        }

        return total;
    }

    private Double getTotalServices(List<ServiceItem> serviceItems) {
        Double total = 0.0;

        for(ServiceItem obj: serviceItems) {
            total += obj.getSellingPrice();
        }

        return total;
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
