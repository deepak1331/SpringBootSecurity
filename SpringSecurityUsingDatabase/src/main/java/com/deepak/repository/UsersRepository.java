package com.deepak.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByUsername(String username);
}
