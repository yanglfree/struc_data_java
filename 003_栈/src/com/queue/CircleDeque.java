package com.queue;

public class CircleDeque<E> {
	private int size;
	private E[] elements;
	private int front;// 队头 头+size = 队尾

	private static final int DEFAUL_CAPACITY = 10;

	public CircleDeque() {
		elements = (E[]) new Object[DEFAUL_CAPACITY];
	}

	public int size() {
		return size;
	}

	public void enQueueFront(E element) {
		ensureCapacity(size + 1);
		front = index(-1);
		elements[front] = element;
		size++;
	}

	public void enQueueRear(E element) {
		ensureCapacity(size + 1);
		elements[index(size)] = element;
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E deQueueFront() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElement;
	}

	public E deQueueRear() {
		int rearIndex = index(size - 1);
		E rearElement = elements[rearIndex];
		elements[rearIndex] = null;
		size--;
		return rearElement;
	}

	private int index(int index) {
//		index = front + index;
//		if (index < 0) {
//			return index + elements.length;
//		}
//		return index % elements.length;

		index = front + index;
		if (index < 0) {
			return index + elements.length;
		}
		return index - (index > elements.length ? elements.length : 0);
	}

	public E front() {
		return elements[front];
	}

	public E rear() {
		return elements[index(size - 1)];
	}

	public void clear() {
		for (int i = front; i < size; i++) {
			elements[index(i)] = null;
		}
		size = 0;
		front = 0;
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
			newElements[i] = elements[index(i)]; // 新数组从0开始重新赋值
		}
		elements = newElements;
		front = 0; // front 重置为0 ！！！！！
		System.out.println(oldCapacity + "扩容为:" + newCapacity);
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capacity=").append(elements.length).append(", front=").append(front).append(", size=")
				.append(size).append(", [");
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
