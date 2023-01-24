package com.gus.carshop.service;

import com.gus.carshop.dto.TokenDTO;
import com.gus.carshop.dto.UserDTO;
import com.gus.carshop.model.User;
import com.gus.carshop.repository.UserRepository;
import com.gus.carshop.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired
	private final UserRepository repository;
	@Autowired
	private final AuthenticationManager authenticationManager;
	@Autowired
	private final JwtService jwtService;

	public AuthService(UserRepository repository, AuthenticationManager authenticationManager, JwtService jwtService) {
		this.repository = repository;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	public ResponseEntity signIn(UserDTO data){
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword())
		);

		var user = repository.findByUsername(data.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username " + data.getUsername() + " not found"));

		var token = new TokenDTO();

		token = jwtService.generateToken(user);

		return ResponseEntity.ok(token);
	}

}
