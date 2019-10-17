package org.froggyfeet.store.controller;

import org.froggyfeet.store.model.Cellphone;
import org.froggyfeet.store.service.interfaces.CellphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CellphoneController {

    @Autowired
    private CellphoneService cellphoneService;

    @GetMapping("/cellphones/{id}")
    public ResponseEntity<Cellphone> get(@PathVariable("id") int id) {
        Cellphone cellphone = cellphoneService.get(id);
        return ResponseEntity.ok().body(cellphone);
    }

    @GetMapping("/cellphones")
    public ResponseEntity<List<Cellphone>> list() {
        List<Cellphone> cellphones = cellphoneService.list();
        return ResponseEntity.ok().body(cellphones);
    }

    @PostMapping("/cellphones")
    public ResponseEntity<?> save(@RequestBody Cellphone cellphone) {
        cellphoneService.save(cellphone);
        return ResponseEntity.ok().body(cellphone);
    }

    @PutMapping("/cellphones/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Cellphone cellphone) {
        Cellphone existingCellphone = cellphoneService.get(id);
        if (existingCellphone == null) {
            return ResponseEntity.badRequest().body("Cellphone with id " + id + " has not been found.");
        }
        existingCellphone.setVendor(cellphone.getVendor());
        existingCellphone.setModel(cellphone.getModel());
        existingCellphone.setScreenDiagonal(cellphone.getScreenDiagonal());
        existingCellphone.setChargePort(cellphone.getChargePort());

        cellphoneService.update(existingCellphone);
        return ResponseEntity.ok().body(existingCellphone);
    }

    @DeleteMapping("/cellphones/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Cellphone existingCellphone = cellphoneService.get(id);
        if (existingCellphone == null) {
            return ResponseEntity.badRequest().body("Cellphone with id " + id + " has not been found.");
        }
        cellphoneService.delete(existingCellphone);
        return ResponseEntity.ok().body("Cellphone has been deleted successfully.");
    }

}
