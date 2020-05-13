package com.liang;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		System.out.println(list.toString());
		System.out.println(list.contains(50));
		System.out.println(list.indexOf(30));
		System.out.println(list.element(1));
	}
}