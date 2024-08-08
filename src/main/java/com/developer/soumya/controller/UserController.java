package com.developer.soumya.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.developer.soumya.dto.UserRequestDto;
import com.developer.soumya.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	public ResponseEntity<?> saveUser(@RequestBody UserRequestDto userRequestDto) {
		var saveUser = userService.saveUser(userRequestDto);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

}
