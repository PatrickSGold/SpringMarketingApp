package com.example.SpringMarketingApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "areas")
public class Area {

    private Long id;
    private String state;
    private String city;
    private String zip_code;
    private int number_of_stores;
    private Long manager_id;

    private MarketingManager manager;

    private List<Store> listOfStores;

    public Area() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @OneToMany(targetEntity = Store.class, mappedBy = "area",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Store> getListOfStores() {
        return listOfStores;
    }

    public void setListOfStores(List<Store> listOfStores) {
        this.listOfStores = listOfStores;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false, referencedColumnName = "id",
            insertable = false, updatable = false)
    public MarketingManager getManager() {
        return manager;
    }

    public void setManager(MarketingManager manager) {
        this.manager = manager;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public int getNumber_of_stores() {
        return number_of_stores;
    }

    public void setNumber_of_stores(int number_of_stores) {
        this.number_of_stores = number_of_stores;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }
}
