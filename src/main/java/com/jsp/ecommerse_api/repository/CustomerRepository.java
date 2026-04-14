package com.jsp.ecommerse_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerse_api.entity.Customer;
import com.jsp.ecommerse_api.entity.User;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByUser(User user);

}
