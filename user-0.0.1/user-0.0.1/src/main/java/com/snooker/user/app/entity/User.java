package com.snooker.user.app.entity;

import com.snooker.user.app.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USER_DETAILS")
public class User extends UserEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9160753905958199881L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "MOBILE",nullable = false)
	private Long mobile;
	@Enumerated(EnumType.STRING)
	private Role roleType;

}
