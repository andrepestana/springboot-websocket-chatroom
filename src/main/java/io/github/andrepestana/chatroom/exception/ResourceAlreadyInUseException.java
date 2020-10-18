package io.github.andrepestana.chatroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyInUseException extends RuntimeException {
	private static final long serialVersionUID = 8928136559700435859L;
	public ResourceAlreadyInUseException(String msg) {
		super(msg);
	}
}
