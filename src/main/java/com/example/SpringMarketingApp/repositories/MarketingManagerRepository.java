package com.example.SpringMarketingApp.repositories;

import com.example.SpringMarketingApp.models.MarketingManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketingManagerRepository extends JpaRepository<MarketingManager, Long> {
}
