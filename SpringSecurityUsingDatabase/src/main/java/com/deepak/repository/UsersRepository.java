package com.deepak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
//CrudRepository<Users, Integer> {

}
