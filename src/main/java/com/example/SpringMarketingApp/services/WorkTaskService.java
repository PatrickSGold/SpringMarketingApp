package com.example.SpringMarketingApp.services;

import com.example.SpringMarketingApp.models.WorkTask;
import com.example.SpringMarketingApp.repositories.WorkTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTaskService {

    @Autowired
    WorkTaskRepository repo;

    public List<WorkTask> listAll() {
        return repo.findAll();
    }

    public void save(WorkTask workTask) {
        repo.save(workTask);
    }

    public WorkTask get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
