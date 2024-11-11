package com.nt.exception;

@SuppressWarnings("serial")
public class NegativeNumberException extends Exception{

	public NegativeNumberException() {
		
	}
	public NegativeNumberException(String msg){
		super(msg);
	}
}
