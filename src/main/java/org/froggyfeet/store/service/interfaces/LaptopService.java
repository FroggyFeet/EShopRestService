package org.froggyfeet.store.service.interfaces;


import org.froggyfeet.store.model.Laptop;

import java.util.List;

public interface LaptopService {
    Laptop get(int id);
    List<Laptop> list();
    void save(Laptop laptop);
    void update(Laptop laptop);
    void delete(Laptop laptop);
}
