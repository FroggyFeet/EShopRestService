package org.froggyfeet.store.service.impls;

import org.froggyfeet.store.jpa.LaptopJpaRepository;
import org.froggyfeet.store.model.Laptop;
import org.froggyfeet.store.service.interfaces.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
    @Autowired
    private LaptopJpaRepository laptopJpaRepository;

    @Override
    public Laptop get(int id) {
        return laptopJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Laptop> list() {
        return laptopJpaRepository.findAll();
    }

    @Override
    public void save(Laptop laptop) {
        laptopJpaRepository.save(laptop);
    }

    @Override
    public void update(Laptop laptop) {
        laptopJpaRepository.save(laptop);
    }

    @Override
    public void delete(Laptop laptop) {
        laptopJpaRepository.delete(laptop);
    }
}
