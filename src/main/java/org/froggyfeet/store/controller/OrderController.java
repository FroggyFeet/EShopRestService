package org.froggyfeet.store.controller;

import org.froggyfeet.store.model.Order;
import org.froggyfeet.store.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> get(@PathVariable("id") int id) {
        Order order = orderService.get(id);
        return ResponseEntity.ok().body(order);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> list() {
        List<Order> orders = orderService.list();
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> save(@RequestBody Order order) {
        Map<String, Object> resultMap = orderService.replaceGoodsFromDatabaseById(order);
        int exitCode = (int) resultMap.get("exitCode");
        if (exitCode == -1) {
            return ResponseEntity.badRequest().body(resultMap.get("message"));
        }
        orderService.save(order);
        return ResponseEntity.ok().body(order);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Order order) {
        Order existingOrder = orderService.get(id);
        if (existingOrder == null) {
            return ResponseEntity.badRequest().body("Order has benn not found.");
        }
        existingOrder.setLocalDateTime(order.getLocalDateTime());
        existingOrder.setAddress(order.getAddress());
        existingOrder.setShippingType(order.getShippingType());
        orderService.update(existingOrder);
        return ResponseEntity.ok().body(existingOrder);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Order existingOrder = orderService.get(id);
        if (existingOrder == null) {
            return ResponseEntity.badRequest().body("Order has not been found.");
        }
        orderService.delete(existingOrder);
        return ResponseEntity.ok().body("Order has been deleted successfully.");
    }
}
