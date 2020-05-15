package com.liang;

public class Person implements Comparable<Person>{
	
	private int age;
	
	public Person(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person e) {
		// TODO Auto-generated method stub
		return age - e.age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person age:" + age;
	}

}
