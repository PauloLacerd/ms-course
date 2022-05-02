package com.ms.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.hroauth.entities.User;
import com.ms.hroauth.services.UserService;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			User user = userService.findByEmail(email);

			return ResponseEntity.ok(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(NOT_FOUND).build();
		}
	}
}
