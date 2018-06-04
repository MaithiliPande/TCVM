package com.yash.teacoffeemachine.exception;

@SuppressWarnings("serial")
public class EmptyFileException extends RuntimeException {
	
	public EmptyFileException(String errorMessage) {
		super(errorMessage);
	}
}
