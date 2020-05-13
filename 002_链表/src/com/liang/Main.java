package com.liang;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list = new SingleLinkedList<>();
		
		list.add(20);
		list.add(1, 30);
		list.add(40);
		list.add(80);
		list.add(2, 55);
		
		System.out.println(list.toString());

	}

}
