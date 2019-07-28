package com.vanilla.crud.exception;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329395867716744319L;

	public ProductNotFoundException(Long id) {
		super("Could not find product " + id);
	}
}
