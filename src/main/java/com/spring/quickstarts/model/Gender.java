package com.spring.quickstarts.model;

public enum Gender {
	MALE('M'), 
	FEMALE('F');

	private Character value;
	Gender(Character c) {
		this.value = c;
	}
	
}
