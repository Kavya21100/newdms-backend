package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.entity.Incident;
import com.example.demo.repo.IncidentRepo;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin
public class IncidentController {
    private final IncidentRepo repo;

    public IncidentController(IncidentRepo repo) { this.repo = repo; }

    @GetMapping
    public List<Incident> getAll() { return repo.findAll(); }

    @PostMapping
    public Incident create(@RequestBody Incident incident) {
        return repo.save(incident);
    }

    @PutMapping("/{id}")
    public Incident update(@PathVariable Long id, @RequestBody Incident incident) {
        incident.setId(id);
        return repo.save(incident);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
