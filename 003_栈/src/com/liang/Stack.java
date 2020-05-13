package com.liang;

/**
 * 栈的实现 --- 用链表来实现
 * @author michaelyang
 *
 * @param <E>
 */
public class Stack<E> {
	
	private List<E> list  = new LinkedList<>();
	
	public int size() {
		return list.size();
	}
	
	public void push(E element) {
		list.add(element);
	}
	
	public E pop() {
		return list.remove(list.size() - 1);
	}
	
	public void clear() {
		list.clear();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public E top() {
		return list.get(size() - 1);
	}

}
