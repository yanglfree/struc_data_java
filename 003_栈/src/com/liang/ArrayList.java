package com.liang;

import java.util.Arrays;

public class ArrayList<E> {
	
	private static final int DEFAULT_CAPACITY = 10; // 默认容量

	private int size;
	private E[] elements;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
		elements = (E[]) new Object[capacity];
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}


	public void add(int index, E element) {
		rangeCheckForAdd(index);

		ensureCapacity(size + 1);

		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
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
		if (oldCapacity > capacity) {
			// 容量够用
			return;
		}
		int newCapacity = oldCapacity + oldCapacity >> 1;
		E[] newElements = (E[]) new Object[capacity];
		;

		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为:" + newCapacity);
	}

	public E remove(int index) {
		rangeCheck(index);
		E value = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;// 最后一位清空
		return value;
	}

	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	public void set(int index, E element) {
		rangeCheck(index);
		elements[index] = element;
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Size:" + size + "Index:" + index);
		}
	}

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Size:" + size + "Index:" + index);
		}
	}

	public int indexOf(E element) {

		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}

		return List.ELEMENT_NOT_FOUND;

	}

	@Override
	public String toString() {
		return "ArrayList [size=" + size + ", elements=" + Arrays.toString(elements) + "]";
	}
}
