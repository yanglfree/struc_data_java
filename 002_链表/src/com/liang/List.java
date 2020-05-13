package com.liang;

public interface List<E> {
	
	static final int ELEMENT_NOT_FOUND = -1;
	
	public int size();
	
	boolean isEmpty();
	
	void clear();
	
	int indexOf(E element);
	
	E remove(int index);
	
	void add(E element);
	
	void add(int index, E element);
	
	E set(E element, int index);
	
	E get(int index);
	
	boolean contains(E element);
}
