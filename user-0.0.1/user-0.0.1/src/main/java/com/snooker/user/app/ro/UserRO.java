package com.snooker.user.app.ro;

import com.snooker.user.app.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserRO {

	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;
	
	private Long mobile;

	private Role roleType;

}
