package com.yash.teacoffeemachine.exception;

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException {

	public EmptyListException(String errorMessage) {
		super(errorMessage);
	}
}
