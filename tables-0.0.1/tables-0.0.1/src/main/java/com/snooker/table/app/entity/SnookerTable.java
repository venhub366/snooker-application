package com.snooker.table.app.entity;

import jakarta.persistence.Column;
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
    
    @Column(name = "base_price")
    private double basePrice;
    
    @Column(name = "hourly_charge")
    private double hourlyCharge;

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


    public SnookerTable(Long id, String size, TableStatus status, double basePrice, double hourlyCharge) {
        this.id = id;
        this.size = size;
        this.status = status;
        this.basePrice = basePrice;
        this.hourlyCharge = hourlyCharge;
    }
    
    public double getBasePrice() {
        return basePrice;
    }
    
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getHourlyCharge() {
        return hourlyCharge;
    }

    public void setHourlyCharge(double hourlyCharge) {
        this.hourlyCharge = hourlyCharge;
    }



    @Override
    public String toString() {
        return "SnookerTable{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", status=" + status +
                ", basePrice=" + basePrice +
                ", hourlyCharge=" + hourlyCharge +
                '}';
    }
}