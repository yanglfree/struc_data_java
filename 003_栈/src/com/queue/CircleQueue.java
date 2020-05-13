package com.queue;

@SuppressWarnings("unchecked")
public class CircleQueue<E> {
	private int size;
	private E[] elements;
	private int front;//队头
	
	private static final int DEFAUL_CAPACITY = 10;
	
	public CircleQueue() {
		elements = (E[]) new Object[DEFAUL_CAPACITY];
	}

	public int size() {
		return size;
	}
	
	public void enQueue(E element) {
		ensureCapacity(size + 1);
		elements[index(size)] = element;
		size++;
	}
	
	/**
	 * 确保容量够用，如果不够用，对数组进行1.5倍扩容
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			// 容量够用
			return;
		}
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];

		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)]; //新数组从0开始重新赋值
		}
		elements = newElements;
		front = 0; //front 重置为0 ！！！！！
		System.out.println(oldCapacity + "扩容为:" + newCapacity);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElement;
	}
	
	private int index(int index) {
		return (front + index) % elements.length;
	}
	
	public E front() {
		return elements[front];
	}
	
	public void clear() {
		for (int i = front; i < index(size); i++) {
			elements[i] = null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capacity=").append(elements.length).append(", front=").append(front).append(", size=").append(size).append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();	
	}
	
}
