package com.liang;


public abstract class AbstractList<E> implements List<E>{
	
	private int size;
	private E[] elements;
	
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public abstract void clear();

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			if (elements[size] == element)
				return true;
		}
		return false;
	}
	
}
