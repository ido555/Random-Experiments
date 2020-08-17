package com.example.exceptions;

@SuppressWarnings("serial")
public class NameAlreadyInUseException extends Exception {
	public NameAlreadyInUseException() {
	super("name is already in use. try a different one");
	}
}
