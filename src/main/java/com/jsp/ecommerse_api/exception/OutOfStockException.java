package com.jsp.ecommerse_api.exception;


public class OutOfStockException extends RuntimeException {
	public OutOfStockException(String message) {
		super(message);
	}
}