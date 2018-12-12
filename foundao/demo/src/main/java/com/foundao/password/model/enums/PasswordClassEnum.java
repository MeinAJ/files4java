package com.foundao.password.model.enums;

public enum PasswordClassEnum {

	C_WEAK("弱", 1), C_MID("中", 2), C_STRONG("强", 3);

	private String name;
	private int value;

	private PasswordClassEnum(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
