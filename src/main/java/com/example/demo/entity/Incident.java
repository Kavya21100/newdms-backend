package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String location;
    private String description;

    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
    private List<ReliefUpdate> reliefUpdates = new ArrayList<>();

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<ReliefUpdate> getReliefUpdates() { return reliefUpdates; }
    public void setReliefUpdates(List<ReliefUpdate> reliefUpdates) { this.reliefUpdates = reliefUpdates; }
}
