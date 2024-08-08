package com.developer.soumya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.soumya.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
