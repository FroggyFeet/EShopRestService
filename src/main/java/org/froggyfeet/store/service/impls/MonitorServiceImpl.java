package org.froggyfeet.store.service.impls;

import org.froggyfeet.store.jpa.MonitorJpaRepository;
import org.froggyfeet.store.model.Monitor;
import org.froggyfeet.store.service.interfaces.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    private MonitorJpaRepository monitorJpaRepository;

    @Override
    public Monitor get(int id) {
        return monitorJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Monitor> list() {
        return monitorJpaRepository.findAll();
    }

    @Override
    public void save(Monitor monitor) {
        monitorJpaRepository.save(monitor);
    }

    @Override
    public void update(Monitor monitor) {
        monitorJpaRepository.save(monitor);
    }

    @Override
    public void delete(Monitor monitor) {
        monitorJpaRepository.delete(monitor);
    }
}
