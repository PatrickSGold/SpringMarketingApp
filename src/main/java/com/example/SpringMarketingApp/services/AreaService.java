package com.example.SpringMarketingApp.services;

import com.example.SpringMarketingApp.models.Area;
import com.example.SpringMarketingApp.repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    AreaRepository repo;

    public List<Area> listAll() {
        return repo.findAll();
    }

    public void save(Area area) {
        repo.save(area);
    }

    public Area get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
