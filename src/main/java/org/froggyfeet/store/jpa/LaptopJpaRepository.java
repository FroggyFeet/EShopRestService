package org.froggyfeet.store.jpa;

import org.froggyfeet.store.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopJpaRepository extends JpaRepository<Laptop, Integer> {
}
