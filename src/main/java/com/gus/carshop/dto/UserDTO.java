package com.gus.carshop.dto;

import java.io.Serializable;
import java.util.Objects;


public class UserDTO implements Serializable {
	private String username;
	private String password;

	public UserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UserDTO() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserDTO userDTO = (UserDTO) o;
		return Objects.equals(username, userDTO.username) && Objects.equals(password, userDTO.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
