package com.lithan.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.model.Users;
import com.lithan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository repo;
	
	@Override
	public Users addUser(Users user) {
		return repo.save(user);}

	@Override
	public List<Users> getAllUsers() {
		return repo.findAll();}
	
	@Override
	public Optional<Users> findUserById(int id) {
		return repo.findById(id);}
	
	@Override
	public void deleteUser(int id) {
		repo.deleteById(id);}
	

	@Override
	public Users getUserById(int id) {
		Users user=null;
		Optional<Users> oldUser = repo.findById(id);
		if(oldUser.isPresent()) {
			user=oldUser.get();
		}
		return user;
	}

	@Override
	public Users login(Users user) {
		Users repouser = repo.findByUsername(user.getUsername());
        if(repouser == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!repouser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
		return repouser;
	}}
