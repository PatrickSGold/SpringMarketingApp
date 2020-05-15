package com.example.SpringMarketingApp.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "work_tasks")
public class WorkTask {

    private Long id;
    private String work_done_today;
    private LocalDate date = LocalDate.now();
    private boolean spoken_to_manager;
    private Long store_id;

    private Store store;

    public WorkTask() {
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
    @JoinColumn(name = "store_id", nullable = false, referencedColumnName = "id",
            insertable = false, updatable = false)
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getWork_done_today() {
        return work_done_today;
    }

    public void setWork_done_today(String work_done_today) {
        this.work_done_today = work_done_today;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isSpoken_to_manager() {
        return spoken_to_manager;
    }

    public void setSpoken_to_manager(boolean spoken_to_manager) {
        this.spoken_to_manager = spoken_to_manager;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }
}
