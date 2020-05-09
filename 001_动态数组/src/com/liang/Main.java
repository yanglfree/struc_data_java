package com.liang;


public class Main {

	
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>(8);
		Person person = new Person(20, "Pogba");
		Person person2 = new Person(21, "Martial");
		Person person3 = new Person(28, "Mata");
		
		list.add(person);
		list.add(person2);
		list.add(person3);
		
		System.out.println(list);
		
		list.clear();
		System.gc();
		System.out.println(list);
	}
}