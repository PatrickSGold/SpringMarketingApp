package com.example.SpringMarketingApp.services;

import com.example.SpringMarketingApp.models.MarketingManager;
import com.example.SpringMarketingApp.repositories.MarketingManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingManagerService {

    @Autowired
    MarketingManagerRepository repo;

    public List<MarketingManager> listAll() {
        return repo.findAll();
    }

    public void save(MarketingManager marketingManager) {
        repo.save(marketingManager);
    }

    public MarketingManager get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
