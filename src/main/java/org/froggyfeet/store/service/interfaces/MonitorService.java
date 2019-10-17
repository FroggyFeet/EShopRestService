package org.froggyfeet.store.service.interfaces;


import org.froggyfeet.store.model.Monitor;

import java.util.List;

public interface MonitorService {
    Monitor get(int id);
    List<Monitor> list();
    void save(Monitor monitor);
    void update(Monitor monitor);
    void delete(Monitor monitor);
}
