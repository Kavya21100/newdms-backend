package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String skills;
    private String availability;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident assignedIncident;

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
    public Incident getAssignedIncident() { return assignedIncident; }
    public void setAssignedIncident(Incident assignedIncident) { this.assignedIncident = assignedIncident; }
}
