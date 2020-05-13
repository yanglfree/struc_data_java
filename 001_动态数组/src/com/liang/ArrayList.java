package com.liang;

import javax.net.ssl.SNIHostName;

/**
 * 动态数组
 * @author michaelyang
 *
 */
@SuppressWarnings("unchecked")
public class ArrayList<E> {
	private int size;
	private static final int DEFAULT_CAPACITY = 8;
	private static final int ELEMENT_NOT_FOUND = -1;
	private E[] elements;
	
	
	public ArrayList(int capacity) {
		capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
		elements = (E[])new Object[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return size;
	}
	
	/**
	 * 扩容
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if(oldCapacity >= capacity) return;
		int newCapacity = oldCapacity + oldCapacity >> 1;
		//将原有的数组移到新数组
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) { return i; }
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {return i;}
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 获取指定索引的元素
	 * @param index
	 * @return 返回的元素
	 */
	public E element(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	/**
	 * 设置指定索引的元素
	 * @param element
	 * @param index
	 * @return 返回原有的元素
	 */
	public E setElement(E element, int index) {
		rangeCheck(index);
		E oldElement = elements[index];
		elements[index] = element;
		return oldElement;
	}
	
	/**
	 * 在数组的末尾添加元素
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}
	
	/**
	 * 在指定的位置添加元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}
	
	/**
	 * 从指定位置移除元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		rangeCheck(index);
		E element = elements[index];
		for (int i = index; i < size; i++) {
			elements[i] = elements[i + 1];
		}
		elements[--size] = null;
		return element;
	}
	
	private void boundsException(int index) {
		throw new IndexOutOfBoundsException("index is: " + index + ", size is: " + size);
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			boundsException(index);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			boundsException(index);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("size is: "+ size + ", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sb.append(", ");
			}
			sb.append(elements[i]);
		}
		sb.append("]");
		return sb.toString();
	}
}
