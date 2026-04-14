package com.jsp.ecommerse_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerse_api.entity.Merchant;
import com.jsp.ecommerse_api.entity.User;
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

	Optional<Merchant> findByUser(User user);

}
