package com.lithan.service;

import java.util.List;
import java.util.Optional;
import com.lithan.model.Users;

public interface UserService {
	Users addUser(Users user);
	Users getUserById(int id);
	List<Users> getAllUsers();
	void deleteUser(int id);
	Optional<Users> findUserById(int id);
	public Users login(Users user);
}


