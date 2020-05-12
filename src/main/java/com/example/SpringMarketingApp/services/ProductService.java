package com.example.SpringMarketingApp.services;

import com.example.SpringMarketingApp.models.Product;
import com.example.SpringMarketingApp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> listAll() {
        return repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }


}
