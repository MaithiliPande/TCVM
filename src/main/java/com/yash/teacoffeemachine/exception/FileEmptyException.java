package com.yash.teacoffeemachine.exception;

@SuppressWarnings("serial")
public class FileEmptyException extends RuntimeException {

	public FileEmptyException(String errorMessage) {
		super(errorMessage);
	}

}
