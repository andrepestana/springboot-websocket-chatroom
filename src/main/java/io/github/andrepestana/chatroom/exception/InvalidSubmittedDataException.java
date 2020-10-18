package io.github.andrepestana.chatroom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidSubmittedDataException extends RuntimeException {
	private static final long serialVersionUID = -7938121764294063861L;
	public InvalidSubmittedDataException(String msg) {
	    super(msg);
	}
}
