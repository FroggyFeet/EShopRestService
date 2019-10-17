package org.froggyfeet.store.jpa;

import org.froggyfeet.store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Integer> {

}
