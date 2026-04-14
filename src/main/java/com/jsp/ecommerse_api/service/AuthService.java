package com.jsp.ecommerse_api.service;

import java.util.Map;

import com.jsp.ecommerse_api.dto.CustomerDto;
import com.jsp.ecommerse_api.dto.MerchantDto;
import com.jsp.ecommerse_api.dto.OtpDto;

public interface AuthService {

	Map<String, Object> login(String email, String password);

	Map<String, Object> viewUser(String email);

	Map<String, Object> updatePassword(String email, String oldPassword, String newPassword);

	Map<String, Object> registerMerchant(MerchantDto merchantDto);

	Map<String, Object> verifyMerchantOtp(OtpDto dto);

	Map<String, Object> resendMerchantOtp(String email);
	
	Map<String, Object> registerCustomer(CustomerDto customerDto);

	Map<String, Object> verifyCustomerOtp(OtpDto dto);

	Map<String, Object> resendCustomerOtp(String email);

}