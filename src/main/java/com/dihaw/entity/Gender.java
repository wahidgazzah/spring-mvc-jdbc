package com.dihaw.entity;

public enum Gender {

	M("Male"), F("Female");

	private String abreviation;

	public String getAbreviation() {
		return abreviation;
	}

	private Gender(String abreviation) {
		this.abreviation = abreviation;
	}

}
