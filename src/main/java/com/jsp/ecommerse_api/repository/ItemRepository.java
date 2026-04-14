package com.jsp.ecommerse_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerse_api.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
