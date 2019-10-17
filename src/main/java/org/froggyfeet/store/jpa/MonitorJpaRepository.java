package org.froggyfeet.store.jpa;

import org.froggyfeet.store.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorJpaRepository extends JpaRepository<Monitor, Integer> {
}
