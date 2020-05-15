package com.example.SpringMarketingApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marketing_managers")
public class MarketingManager {

    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private int phone_number;

    private List<Area> listOfAreas;

    public MarketingManager() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(targetEntity = Area.class, mappedBy = "manager",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Area> getListOfAreas() {
        return listOfAreas;
    }

    public void setListOfAreas(List<Area> listOfAreas) {
        this.listOfAreas = listOfAreas;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

}
