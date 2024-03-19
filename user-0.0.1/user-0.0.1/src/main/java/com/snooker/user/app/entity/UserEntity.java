package com.snooker.user.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public abstract class UserEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5243926717581434376L;
    @Column(name = "CREATED_TIME",nullable = false)
	private LocalDateTime createdDate;
    @Column(name = "UPDATED_TIME",nullable = true)
	private LocalDateTime updatedDate;
	
	
}
