package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ReliefUpdate;

public interface ReliefUpdateRepo extends JpaRepository<ReliefUpdate, Long> {
}
