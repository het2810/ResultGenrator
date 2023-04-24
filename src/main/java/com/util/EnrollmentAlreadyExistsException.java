package com.util;

public class EnrollmentAlreadyExistsException extends Exception{
	public EnrollmentAlreadyExistsException() {
        super("Enrollment Already exist Please try another Enrollment");
    }
}	
