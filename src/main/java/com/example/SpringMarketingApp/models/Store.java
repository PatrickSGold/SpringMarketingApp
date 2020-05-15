package com.example.SpringMarketingApp.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store {

    private Long id;
    private String store_name;
    private String store_manager;
    private Long area_id;

    private Area area;

    private List<WorkTask> listOfWorkTasks;
    private List<Product> listOfProducts;

    public Store() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false, referencedColumnName = "id",
            insertable = false, updatable = false)
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @OneToMany(targetEntity = WorkTask.class, mappedBy = "store",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<WorkTask> getListOfWorkTasks() {
        return listOfWorkTasks;
    }

    public void setListOfWorkTasks(List<WorkTask> listOfWorkTasks) {
        this.listOfWorkTasks = listOfWorkTasks;
    }

    @OneToMany(targetEntity = Product.class, mappedBy = "store",
            cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_manager() {
        return store_manager;
    }

    public void setStore_manager(String store_manager) {
        this.store_manager = store_manager;
    }

    public Long getArea_id() {
        return area_id;
    }

    public void setArea_id(Long area_id) {
        this.area_id = area_id;
    }
}
