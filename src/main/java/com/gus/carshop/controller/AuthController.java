package com.gus.carshop.controller;

import com.gus.carshop.dto.UserDTO;
import com.gus.carshop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping()
	public ResponseEntity signIn(
		@RequestBody UserDTO data
	) {
		if (data == null || data.getUsername() == null || data.getUsername().isBlank() || data.getPassword() == null || data.getPassword().isBlank()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		}

		var token = authService.signIn(data);

		if(token == null){
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		}

		return token;
	}
}
