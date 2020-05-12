package com.example.SpringMarketingApp.repositories;

import com.example.SpringMarketingApp.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
