package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repo.*;

@RestController
@RequestMapping("/api/relief")
@CrossOrigin
public class ReliefController {
    private final ReliefUpdateRepo reliefRepo;
    private final IncidentRepo incidentRepo;

    public ReliefController(ReliefUpdateRepo reliefRepo, IncidentRepo incidentRepo) {
        this.reliefRepo = reliefRepo;
        this.incidentRepo = incidentRepo;
    }

    @GetMapping
    public List<ReliefUpdate> getAll() {
        return reliefRepo.findAll();
    }

    @PostMapping("/{incidentId}")
    public ReliefUpdate addUpdate(@PathVariable Long incidentId, @RequestBody ReliefUpdate update) {
        Incident incident = incidentRepo.findById(incidentId).orElseThrow();
        update.setIncident(incident);
        return reliefRepo.save(update);
    }
}
