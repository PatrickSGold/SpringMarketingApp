package com.example.SpringMarketingApp.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    private Long id;
    private Long products_given_this_week;
    private Long total_products;
    private Long requested_products;

    private Store store;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false, referencedColumnName = "id")
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Long getProducts_given_this_week() {
        return products_given_this_week;
    }

    public void setProducts_given_this_week(Long products_given_this_week) {
        this.products_given_this_week = products_given_this_week;
    }

    public Long getTotal_products() {
        return total_products;
    }

    public void setTotal_products(Long total_products) {
        this.total_products = total_products;
    }

    public Long getRequested_products() {
        return requested_products;
    }

    public void setRequested_products(Long requested_products) {
        this.requested_products = requested_products;
    }
}
