package com.developers.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developers.Exception.ResourceNotFoundException;
import com.developers.pojos.Products;
import com.developers.pojos.UserRole;
import com.developers.pojos.Users;
import com.developers.repository.ProductRepository;
import com.developers.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	UserRepository userRepo;
	ProductRepository prodRepo;

	@PostMapping("/register")
	public ResponseEntity<String> doRegister(@RequestBody Users user) {
		userRepo.save(user);
		System.out.println(user);
		return new ResponseEntity<String>("Registered Successfully", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Users> doLogin(@RequestBody Users user) {
		Users user1 = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		System.out.println(user);
		if (user1 == null) {
			return new ResponseEntity<Users>(new Users(), HttpStatus.OK);
		}
		return new ResponseEntity<Users>(userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()),
				HttpStatus.OK);
//	        	  System.out.println(user);
//	        	  return null;
	}

	@GetMapping("/allUsers/{role}")
	public ResponseEntity<List<Users>> getAllUsers(@PathVariable String role) {
		List<Users> liuser = userRepo.findByRole(UserRole.valueOf(role.toUpperCase()));
		return new ResponseEntity<List<Users>>(liuser, HttpStatus.OK);
  
	}
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int userId){
		Users user= userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not exist with id: "+userId));
		System.out.println(user);
		userRepo.delete(user);
		Map<String, Boolean> response =new HashMap<String, Boolean>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int productId){
		Products product= prodRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("User not exist with id: "+productId));
		System.out.println(product);
		prodRepo.delete(product);
		Map<String, Boolean> response =new HashMap<String, Boolean>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	
}}
