package org.froggyfeet.store.service.interfaces;


import org.froggyfeet.store.model.Cellphone;

import java.util.List;

public interface CellphoneService {
    Cellphone get(int id);
    List<Cellphone> list();
    void save(Cellphone cellphone);
    void update(Cellphone cellphone);
    void delete(Cellphone cellphone);
}
