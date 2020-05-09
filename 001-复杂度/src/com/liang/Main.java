package com.liang;

import java.awt.List;
import java.util.ArrayList;

import com.liang.Times.Task;

public class Main {

	public static void main(String[] args) {		
//		System.out.println(fib(60));
//		System.out.println(fib2(60));
		
		
		int n = 49;
		Times.test("fib 递归式", new Task() {
			@Override
			public void execute() {
				fib(n);
			}
		});
		
		Times.test("fib", new Task() {
			@Override
			public void execute() {
				fib2(n);
			}
		});
	}
	/**
	 * 	斐波那契数列求和  递归算法，效率非常低 复杂度 O(2^n)
	 */
	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}	
		return fib(n - 1) + fib(n - 2);
	}
	
	/**
	 * 	斐波那契数列求和  优化算法 O(n)
	 */
	public static int fib2(int n) {
		if (n <= 1) {
			return n;
		}
		
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	

}
 