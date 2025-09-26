package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Volunteer;

public interface VolunteerRepo extends JpaRepository<Volunteer, Long> {
}
