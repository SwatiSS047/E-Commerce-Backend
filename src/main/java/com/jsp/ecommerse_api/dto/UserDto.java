package com.jsp.ecommerse_api.dto;

import lombok.Data;

@Data
public class UserDto {
	private String name;
	private String email;
	private Long mobile;
	private String role;
}