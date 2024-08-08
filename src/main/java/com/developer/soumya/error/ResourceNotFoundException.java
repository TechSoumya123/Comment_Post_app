package com.developer.soumya.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ResourceNotFoundException(String message) {
		this.message = message;
	}

}
