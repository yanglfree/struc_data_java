package com.liang;

public class Main {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(11);
		stack.push(13);
		stack.push(14);
		stack.push(17);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
