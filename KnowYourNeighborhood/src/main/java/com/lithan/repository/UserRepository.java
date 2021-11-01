package com.lithan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByUsername(String username);
}
