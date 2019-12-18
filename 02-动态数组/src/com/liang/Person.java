package com.liang;

public class Person {
	private String name;
	private int age;
		
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [nameString=" + name + ", age=" + age + "]";
	}
}
