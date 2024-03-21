package com.snooker.table.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class SnookerTable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;
    private boolean available;

    // Default constructor (required by JPA)
    public SnookerTable() {
    }

    // Constructor with parameters to initialize all fields
    public SnookerTable(String size, boolean available) {
        this.size = size;
        this.available = available;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // You can also override toString() for logging purposes or debugging
    @Override
    public String toString() {
        return "SnookerTable{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", available=" + available +
                '}';
    }
}
