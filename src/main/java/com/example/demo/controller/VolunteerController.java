package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repo.*;

@RestController
@RequestMapping("/api/volunteers")
@CrossOrigin
public class VolunteerController {
    private final VolunteerRepo repo;
    private final IncidentRepo incidentRepo;

    public VolunteerController(VolunteerRepo repo, IncidentRepo incidentRepo) {
        this.repo = repo;
        this.incidentRepo = incidentRepo;
    }

    @GetMapping
    public List<Volunteer> getAll() { return repo.findAll(); }

    @PostMapping
    public Volunteer create(@RequestBody Volunteer volunteer) {
        return repo.save(volunteer);
    }

    @PutMapping("/{id}/assign/{incidentId}")
    public Volunteer assign(@PathVariable Long id, @PathVariable Long incidentId) {
        Volunteer v = repo.findById(id).orElseThrow();
        Incident incident = incidentRepo.findById(incidentId).orElseThrow();
        v.setAssignedIncident(incident);
        return repo.save(v);
    }
}
