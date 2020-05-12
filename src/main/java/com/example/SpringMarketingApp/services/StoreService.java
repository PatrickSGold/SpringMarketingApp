package com.example.SpringMarketingApp.services;

import com.example.SpringMarketingApp.models.Store;
import com.example.SpringMarketingApp.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository repo;

    public List<Store> listAll(Long areaId) {
        return repo.findAll();
    }

    public void save(Store store) {
        repo.save(store);
    }

    public Store get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
