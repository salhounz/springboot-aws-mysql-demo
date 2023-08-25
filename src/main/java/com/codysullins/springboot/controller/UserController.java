package com.codysullins.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codysullins.springboot.entity.User;
import com.codysullins.springboot.exception.ResourceNotFoundException;
import com.codysullins.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") long userId) {
		return userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("No user with ID: " + userId + " located."));

	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}

	@PutMapping("/{id}")
	public User update(@RequestBody User user, @PathVariable("id") Long userId) {
		User updatedUsr = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry! No user with ID: " + userId + " located."));
		// Update information here
		updatedUsr.setFirstName(user.getFirstName());
		updatedUsr.setLastName(user.getLastName());
		updatedUsr.setEmail(user.getEmail());

		return userRepo.save(updatedUsr);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long userId) {
		User deletedUsr = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry! No user with ID: " + userId + " located."));
		userRepo.delete(deletedUsr);

		return ResponseEntity.ok().build();

	}

}
