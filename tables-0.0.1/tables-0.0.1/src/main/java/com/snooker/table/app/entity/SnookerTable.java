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
    private TableStatus status;

    public SnookerTable() {
    }
    
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


	public TableStatus getStatus() {
		return status;
	}


	public void setStatus(TableStatus status) {
		this.status = status;
	}


	public SnookerTable(Long id, String size, TableStatus status) {
		super();
		this.id = id;
		this.size = size;
		this.status = status;
	}


	// You can also override toString() for logging purposes or debugging
    @Override
    public String toString() {
        return "SnookerTable{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", status" + status +
                '}';
    }
}
