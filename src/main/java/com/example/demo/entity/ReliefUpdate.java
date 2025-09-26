package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ReliefUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String updateInfo;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUpdateInfo() { return updateInfo; }
    public void setUpdateInfo(String updateInfo) { this.updateInfo = updateInfo; }
    public Incident getIncident() { return incident; }
    public void setIncident(Incident incident) { this.incident = incident; }
}
