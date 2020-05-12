package com.example.SpringMarketingApp.repositories;

import com.example.SpringMarketingApp.models.WorkTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTaskRepository extends JpaRepository<WorkTask, Long> {
}
