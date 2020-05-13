package com.liang;

public abstract class AbstractList<E> implements List<E>{
	
	protected int size;
	
	public int size() {
		
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	
	/**
	 * 在数组的末尾添加元素
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}
	
	
	protected void boundsException(int index) {
		throw new IndexOutOfBoundsException("index is: " + index + ", size is: " + size);
	}
	
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			boundsException(index);
		}
	}
	
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			boundsException(index);
		}
	}
	
}
