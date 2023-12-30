package com.serpa.serpabooks.models.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
	ADMIN("Admin"), 
	USER("User");

	private String role;

	UserRoleEnum(String role) {
		this.role = role;
	}
}
