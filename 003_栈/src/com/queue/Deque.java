package com.queue;

import com.liang.LinkedList;
import com.liang.List;

/**
 * 双端队列
 * @author michaelyang
 *
 * @param <E>
 */
public class Deque<E> {
	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}
	
	public void enQueueFront(E element) {
		list.add(0, element);
	}
	
	public void enQueueRear(E element) {
		list.add(element);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public E deQueueFront() {
		return list.remove(size() - 1);
	}
	
	public E deQueueRear() {
		return list.remove(0);
	}
	
	public E front() {
		return list.get(0);
	}
	
	public E rear() {
		return list.get(size() - 1);
	}
	
	public void clear() {
		list.clear();
	}
	

}
