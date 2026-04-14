package com.jsp.ecommerse_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ecommerse_api.entity.Customer;
import com.jsp.ecommerse_api.entity.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

	List<CustomerOrder> findByCustomer(Customer customer);

}
