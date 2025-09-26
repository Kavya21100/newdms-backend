package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ResourceItem;

public interface ResourceItemRepo extends JpaRepository<ResourceItem, Long> {
}
