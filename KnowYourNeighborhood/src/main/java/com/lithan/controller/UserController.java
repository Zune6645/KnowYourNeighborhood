package com.lithan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.model.Users;
import com.lithan.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	public UserService service;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping(value="/")
	public String home() {
		return "User";}
	
	@GetMapping(value="/allUsers")
	public List<Users> getAllUsers(){
		return service.getAllUsers();}
	
	@PostMapping("/addUser")
	public Users addUser(@RequestBody Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); 
			return service.addUser(user);}
	
	@PostMapping("/loginuser")
	public Users loginuser(@RequestBody Users user) {
		return service.login(user);}
	 
	@GetMapping(value="/allUser/{id}")
	public Optional<Users> findUserById(@PathVariable int id){
		return service.findUserById(id);}
	
	@DeleteMapping(value="/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUser(id);	}
	
	@PutMapping(value="/updateUser/{id}")
	public Users updateUser(@RequestBody Users user, @PathVariable int id){
		Optional<Users> oldInfo=service.findUserById(id);
		if(oldInfo.isPresent()) {
			Users obj=oldInfo.get();
			obj.setId(user.getId());
			obj.setUsername(user.getUsername());
			obj.setEmail(user.getEmail());
			obj.setPassword(user.getPassword());
			return service.addUser(obj);}
		else{
			return null;
		}}}
