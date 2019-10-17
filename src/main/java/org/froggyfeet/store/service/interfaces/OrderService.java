package org.froggyfeet.store.service.interfaces;

import org.froggyfeet.store.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Order get(int id);

    List<Order> list();

    void save(Order order);

    void update(Order order);

    void delete(Order order);

    Map<String, Object> replaceGoodsFromDatabaseById(Order order);
}
