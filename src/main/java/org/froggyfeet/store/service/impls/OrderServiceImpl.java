package org.froggyfeet.store.service.impls;

import org.froggyfeet.store.jpa.OrderJpaRepository;
import org.froggyfeet.store.model.Cellphone;
import org.froggyfeet.store.model.Laptop;
import org.froggyfeet.store.model.Monitor;
import org.froggyfeet.store.model.Order;
import org.froggyfeet.store.service.interfaces.CellphoneService;
import org.froggyfeet.store.service.interfaces.LaptopService;
import org.froggyfeet.store.service.interfaces.MonitorService;
import org.froggyfeet.store.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderJpaRepository orderJpaRepository;
    @Autowired
    private CellphoneService cellphoneService;
    @Autowired
    private LaptopService laptopService;
    @Autowired
    private MonitorService monitorService;

    @Override
    public Order get(int id) {
        return orderJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> list() {
        return orderJpaRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderJpaRepository.save(order);
    }

    @Override
    public void update(Order order) {
        orderJpaRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        orderJpaRepository.delete(order);
    }

    @Override
    public Map<String, Object> replaceGoodsFromDatabaseById(Order order) {
        String cellphonesReplacementResult = replaceCellphones(order);
        String laptopsReplacementResult = replaceLaptops(order);
        String monitorsReplacementResult = replaceMonitors(order);

        String resultMessage = cellphonesReplacementResult + laptopsReplacementResult + monitorsReplacementResult;
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message", resultMessage);
        resultMap.put("exitCode", resultMessage.isEmpty() ? 0 : -1);
        return resultMap;
    }

    private String replaceCellphones(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Cellphone> cellphones = order.getCellphones();
        if (cellphones != null) {
            for (int i = 0; i < cellphones.size(); i++) {
                Cellphone cellphone = cellphones.get(i);
                int index = cellphones.indexOf(cellphone);
                if (cellphone.getId() != null) {
                    Cellphone existingCellphone = cellphoneService.get(cellphone.getId());
                    if (existingCellphone != null) {
                        cellphones.remove(cellphone);
                        cellphones.add(index, existingCellphone);
                    } else {
                        stringBuilder.append(String.format("Id field in the cellphone with index [%s] has not been found.\n", index));
                    }
                } else {
                    stringBuilder.append(String.format("Cellphone with id [%s] has not been found.\n", cellphone.getId()));
                }
            }
        }
        return stringBuilder.toString();
    }

    private String replaceLaptops(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Laptop> laptops = order.getLaptops();
        if (laptops != null) {
            for (int i = 0; i < laptops.size(); i++) {
                Laptop laptop = laptops.get(i);
                int index = laptops.indexOf(laptop);
                if (laptop.getId() != null) {
                    Laptop existingLaptop = laptopService.get(laptop.getId());
                    if (existingLaptop != null) {
                        laptops.remove(laptop);
                        laptops.add(index, existingLaptop);
                    } else {
                        stringBuilder.append(String.format("Id field in the laptop with index [%s] has not been found.\n", index));
                    }
                } else {
                    stringBuilder.append(String.format("Laptop with id [%s] has not been found.\n", laptop.getId()));
                }
            }
        }
        return stringBuilder.toString();
    }

    private String replaceMonitors(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Monitor> monitors = order.getMonitors();
        if (monitors != null) {
            for (int i = 0; i < monitors.size(); i++) {
                Monitor monitor = monitors.get(i);
                int index = monitors.indexOf(monitor);
                if (monitor.getId() != null) {
                    Monitor existingMonitor = monitorService.get(monitor.getId());
                    if (existingMonitor != null) {
                        monitors.remove(monitor);
                        monitors.add(index, existingMonitor);
                    } else {
                        stringBuilder.append(String.format("Id field in the monitor with index [%s] has not been found.\n", index));
                    }
                } else {
                    stringBuilder.append(String.format("Monitor with id [%s] has not been found.\n", monitor.getId()));
                }
            }
        }
        return stringBuilder.toString();
    }
}
