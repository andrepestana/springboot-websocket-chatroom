package io.github.andrepestana.chatroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8928136559700435859L;
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}