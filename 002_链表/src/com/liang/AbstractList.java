package com.liang;

public abstract class AbstractList<E> implements List<E> {
	
	protected int size;
	
	public int size() {
		return size;
	}
	
	protected boolean contains(E element) {
		return indexOf(element) >= 0;
	}

	public void add(E element) {
		add(size, element);
	}

	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Size:" + size + "Index:" + index);
		}
	}

	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Size:" + size + "Index:" + index);
		}
	}
}
