package com.example.SpringMarketingApp.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    private Long id;
    private Long products_given;
    private Long total_products;
    private Long requested_products;
    private Long store_id;

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
    @JoinColumn(name = "store_id", nullable = false, referencedColumnName = "id",
            insertable = false, updatable = false)
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Long getProducts_given() {
        return products_given;
    }

    public void setProducts_given(Long products_given) {
        this.products_given = products_given;
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

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }
}
