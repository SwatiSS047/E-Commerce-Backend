package com.jsp.ecommerse_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerse_api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByEmail(String adminEmail);

	Optional<User> findByEmail(String email);

	boolean existsByEmailOrMobile(String email, Long mobile);

}
