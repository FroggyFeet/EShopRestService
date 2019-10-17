package org.froggyfeet.store.service.impls;

import org.froggyfeet.store.jpa.CellphoneJpaRepository;
import org.froggyfeet.store.model.Cellphone;
import org.froggyfeet.store.service.interfaces.CellphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellphoneServiceImpl implements CellphoneService {
    @Autowired
    private CellphoneJpaRepository cellphoneJpaRepository;

    @Override
    public Cellphone get(int id) {
        return cellphoneJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cellphone> list() {
        return cellphoneJpaRepository.findAll();
    }

    @Override
    public void save(Cellphone cellphone) {
        cellphoneJpaRepository.save(cellphone);
    }

    @Override
    public void update(Cellphone cellphone) {
        cellphoneJpaRepository.save(cellphone);
    }

    @Override
    public void delete(Cellphone cellphone) {
        cellphoneJpaRepository.delete(cellphone);
    }
}
