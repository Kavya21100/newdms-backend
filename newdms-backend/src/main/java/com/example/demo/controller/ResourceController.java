package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.entity.ResourceItem;
import com.example.demo.repo.ResourceItemRepo;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin
public class ResourceController {
    private final ResourceItemRepo repo;

    public ResourceController(ResourceItemRepo repo) { this.repo = repo; }

    @GetMapping
    public List<ResourceItem> getAll() { return repo.findAll(); }

    @PostMapping
    public ResourceItem create(@RequestBody ResourceItem resource) {
        return repo.save(resource);
    }

    @PutMapping("/{id}")
    public ResourceItem update(@PathVariable Long id, @RequestBody ResourceItem resource) {
        resource.setId(id);
        return repo.save(resource);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
