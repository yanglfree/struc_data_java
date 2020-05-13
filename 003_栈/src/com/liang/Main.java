package com.liang;

import com.queue.CircleDeque;
import com.queue.CircleQueue;

public class Main {
	
	private static void test1() {
		CircleQueue<Integer> queue = new CircleQueue<>();
		
		// 0 1 2 3 4 5 6 7 8 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		
		// null null null null null 5 6 7 8 9
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		
		// null null null null null 5 6 7 8 9
		for (int i = 15; i < 23; i++) {
			queue.enQueue(i);
		}
		
		System.out.println(queue);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}
	
	private static void test2() {
		CircleDeque<Integer> deque = new CircleDeque<>();
		for (int i = 0; i < 10; i++) {
			deque.enQueueFront(i + 1);
			deque.enQueueRear(i + 100);
		}
		
		for (int i = 0; i < 3; i++) {
			deque.deQueueFront();
			deque.deQueueRear();
		}
		deque.enQueueFront(11);
		deque.enQueueFront(12);
		System.out.println(deque);
		
		while (!deque.isEmpty()) {
			System.out.println(deque.deQueueFront());
		}
	}
	
	public static void main(String[] args) {
		test2();
	}
}
