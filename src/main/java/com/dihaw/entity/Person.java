package com.dihaw.entity;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name, email;
	private int age;
	
	
	public Person(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String toString(){ 
		return String.format("Person [name = %s, email = %s, age = %d]", name, email, age);
	}
	
	public static List<Person> createPersons() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Wahid", "wahid.gazzah@gmail.com", 29));
		persons.add(new Person("Amine", "amin@mail.com", 28));
		persons.add(new Person("wael", "wael@mail.com", 29));
		persons.add(new Person("Mouhamed", "wael@mail.com", 32));
		persons.add(new Person("Zakariya", "zak@mail.com", 33));
		persons.add(new Person("Salah", "salah@mail.com", 31));
		return persons;
	}
}

