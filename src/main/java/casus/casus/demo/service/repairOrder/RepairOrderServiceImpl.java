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
            PartItemOrderJoinColumn partItemOrderJoinColumn = new PartItemOrderJoinColumn();
            PartItemID partItemID = new PartItemID();

            partItemID.setPartItem(obj);
            partItemID.setRepairOrder(r);

            partItemOrderJoinColumn.setId(partItemID);

            partItemOrderListRepository.save(partItemOrderJoinColumn);
        });

        object.getUsedServices().forEach(obj ->{
            ServiceItemOrderJoinColumn serviceItemOrderJoinColumn = new ServiceItemOrderJoinColumn();
            ServiceItemID serviceItemID = new ServiceItemID();

            serviceItemID.setServiceItem(obj);
            serviceItemID.setRepairOrder(r);

            serviceItemOrderJoinColumn.setId(serviceItemID);

            serviceItemOrderListRepository.save(serviceItemOrderJoinColumn);
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

        //lijst met met items die horen bij deze RepairItems uit de tussentabel RepairOrderItems halen, deze worden dan op een DTO gezet om te kunnen tonen
        List<PartItemOrderJoinColumn> partItemOrderJoinColumn = getListRepairOrderItems(repairOrder.getId());
        List<PartItem> partItemsList = getListPartItem(partItemOrderJoinColumn);
        repairOrderDTO.setUsedItems(partItemsList);

        List<ServiceItemOrderJoinColumn> serviceItemOrderJoinColumn = getListRepairOrderServices(repairOrder.getId());
        List<ServiceItem> serviceItemsList = getListServiceItem(serviceItemOrderJoinColumn);
        repairOrderDTO.setUsedServices(serviceItemsList);

        Double totalItems = getTotalItems(repairOrderDTO.getUsedItems());
        Double totalServices = getTotalServices(repairOrderDTO.getUsedServices());

        repairOrderDTO.setTotalPriceInTax((totalItems + totalServices) * taxRate);
        repairOrderDTO.setTotalPriceExTax(totalItems + totalServices);
        repairOrderDTO.setTotalTaxAmount(repairOrderDTO.getTotalPriceInTax()-repairOrderDTO.getTotalPriceExTax());
        return repairOrderDTO;
    }

    //haalt lijst van partItem uit SQL via repository
    private List<PartItemOrderJoinColumn> getListRepairOrderItems(Long repairOrderId){
        List<PartItemOrderJoinColumn> PartItemOrderJoinColumn = partItemOrderListRepository.findAllByRepairOrderId(repairOrderId);
        return PartItemOrderJoinColumn;
    }
    private  List<ServiceItemOrderJoinColumn> getListRepairOrderServices(Long repairOrderId){
        List<ServiceItemOrderJoinColumn> serviceItemOrderJoinColumn = serviceItemOrderListRepository.findAllByRepairOrderId(repairOrderId);
        return serviceItemOrderJoinColumn;
    }

    //vertaalt de tabel uit SQL naar een lijst met partItems objecten
    private List<PartItem> getListPartItem(List<PartItemOrderJoinColumn> partItemOrderJoinColumn){
        List<PartItem> listPartItems = new ArrayList<>();

        partItemOrderJoinColumn.forEach(obj -> {
            listPartItems.add(obj.getId().getPartItem());
        });
        return listPartItems;
    }

    private List<ServiceItem> getListServiceItem(List<ServiceItemOrderJoinColumn> serviceItemOrderJoinColumn){
        List<ServiceItem> listServiceItem = new ArrayList<>();

        serviceItemOrderJoinColumn.forEach(obj -> {
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

    //GET list By Status
    public List<RepairOrder> getByStatus (OrderStatus status){
        return repository.findByStatus(status);
    }
    //UPDATE / PUT
    @Override
    public RepairOrder checkIfExists (RepairOrder object){
        return null;
    }

    //DELETE
    @Override
    public String deleteObject(Long id) {
        repository.deleteById(id);
        return "Object removed!"+id;
    }
}
