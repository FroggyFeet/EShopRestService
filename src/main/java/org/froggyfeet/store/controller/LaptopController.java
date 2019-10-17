package org.froggyfeet.store.controller;

import org.froggyfeet.store.model.Laptop;
import org.froggyfeet.store.service.interfaces.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/laptops/{id}")
    public ResponseEntity<Laptop> get(@PathVariable("id") int id) {
        Laptop laptop = laptopService.get(id);
        return ResponseEntity.ok().body(laptop);
    }

    @GetMapping("/laptops")
    public ResponseEntity<List<Laptop>> list() {
        List<Laptop> laptops = laptopService.list();
        return ResponseEntity.ok().body(laptops);
    }

    @PostMapping("/laptops")
    public ResponseEntity<?> save(@RequestBody Laptop laptop) {
        laptopService.save(laptop);
        return ResponseEntity.ok().body(laptop);
    }

    @PutMapping("/laptops/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Laptop laptop) {
        Laptop existingLaptop = laptopService.get(id);
        if (existingLaptop == null) {
            return ResponseEntity.badRequest().body("Laptop with id " + id + " has not been found.");
        }
        existingLaptop.setVendor(laptop.getVendor());
        existingLaptop.setModel(laptop.getModel());
        existingLaptop.setOperatingSystem(laptop.getOperatingSystem());
        existingLaptop.setProcessor(laptop.getProcessor());
        laptopService.update(existingLaptop);
        return ResponseEntity.ok().body(existingLaptop);
    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Laptop existingLaptop = laptopService.get(id);
        if (existingLaptop == null) {
            return ResponseEntity.badRequest().body("Laptop with id " + id + " has net been found.");
        }
        laptopService.delete(existingLaptop);
        return ResponseEntity.ok().body("Laptop has been removed successfully.");
    }
}
