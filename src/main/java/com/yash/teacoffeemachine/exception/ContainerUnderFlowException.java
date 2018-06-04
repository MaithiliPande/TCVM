package com.yash.teacoffeemachine.exception;

@SuppressWarnings("serial")
public class ContainerUnderFlowException extends RuntimeException {
	public ContainerUnderFlowException(String errorMessage) {
		super(errorMessage);
	}

}
