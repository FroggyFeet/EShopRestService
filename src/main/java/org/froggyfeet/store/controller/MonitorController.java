package org.froggyfeet.store.controller;

import org.froggyfeet.store.model.Monitor;
import org.froggyfeet.store.service.interfaces.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonitorController {
    @Autowired
    private MonitorService monitorService;

    @GetMapping("/monitors/{id}")
    public ResponseEntity<Monitor> get(@PathVariable("id") int id) {
        Monitor monitor = monitorService.get(id);
        return ResponseEntity.ok().body(monitor);
    }

    @GetMapping("/monitors")
    public ResponseEntity<List<Monitor>> list() {
        List<Monitor> monitors = monitorService.list();
        return ResponseEntity.ok().body(monitors);
    }

    @PostMapping("/monitors")
    public ResponseEntity<?> save(@RequestBody Monitor monitor) {
        monitorService.save(monitor);
        return ResponseEntity.ok().body(monitor);
    }

    @PutMapping("/monitors/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Monitor monitor) {
        Monitor existingMonitor = monitorService.get(id);
        if (existingMonitor == null) {
            return ResponseEntity.badRequest().body("Monitor with id " + id + " has not been found.");
        }
        existingMonitor.setVendor(monitor.getVendor());
        existingMonitor.setModel(monitor.getModel());
        existingMonitor.setDiagonal(monitor.getDiagonal());
        existingMonitor.setButtonsType(monitor.getButtonsType());
        monitorService.save(existingMonitor);
        return ResponseEntity.ok().body(existingMonitor);

    }

    @DeleteMapping("/monitors/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Monitor existingMonitor = monitorService.get(id);
        if (existingMonitor == null) {
            return ResponseEntity.badRequest().body("Monitor with id " + id + " has not been found.");
        }
        monitorService.delete(existingMonitor);
        return ResponseEntity.ok().body("Monitor has been deleted successfully.");
    }
}
