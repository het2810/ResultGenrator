package com.constants;

public enum Role {
	ADMIN(1),
    STUDENT(2),
    FACULTY(3);

    private final int value;

    private Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
