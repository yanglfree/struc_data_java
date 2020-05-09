package com.liang;

public interface List<E> {
	
	static final int ELEMENT_NOT_FOUND = -1; // 元素未找到
	
	int size();
	
	void clear();
	
	void add(E element);
	
	void add(int index, E element);
	
	E remove(int index);
	
	E get(int index);
	
	void set(int index, E element);
	int indexOf(E element);

	boolean isEmpty();
	
	
}
