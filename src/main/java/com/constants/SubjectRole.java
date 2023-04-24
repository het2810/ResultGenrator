package com.constants;

public enum SubjectRole {
	C(1),
	JAVA(2),
	PYTHON(3),
	MATHS(4);
	
	private final int value;
	
	private SubjectRole(int value) {
	        this.value = value;
	   }
	public int getValue() {
        return value;
    }
	
}
