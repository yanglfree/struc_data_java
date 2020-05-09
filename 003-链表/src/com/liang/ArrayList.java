package com.liang;
import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> implements List{


	/**
	 * 默认的数组大小
	 */
	private static final int DEFAULT_CAPACITY = 5;
	private static final int ELEMENT_NOT_FOUND = -1;

	public ArrayList(int capacity) {
		size = size < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : size;
		elements = (E[]) new Object[capacity];
	}

	public ArrayList() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	/**
	 * 获取数组的大小
	 * 
	 * @return 
	 */
	public int size() {
		return size;
	}

	/**
	 * 数组是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 是否包含指定的元素
	 * 
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		for (int i = 0; i < size; i++) {
			if (elements[size] == element)
				return true;
		}
		return false;
	}

	/**
	 * 添加元素
	 * 
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}

	/**
	 * 获取指定索引的元素
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (index <= size) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		return elements[index];
	}

	/**
	 * 设置指定位置的数据
	 * 
	 * @param index
	 * @param element
	 * @return 指定位置的原始数据
	 */
	public E set(int index, E element) {
		if (index <= size) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		E old = elements[index];
		elements[index] = element;
		return old;
	}

	/**
	 * 在指定位置添加数据
	 * 
	 * @param index
	 * @param element
	 */
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
	 * 保证要有capacity的容量
	 * 
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity)
			return;

		int newCapacity = oldCapacity + (oldCapacity >> 1);// 不用oldCapacity * 1.5的写法，浮点数运算比位运算要慢
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;

		System.out.println(oldCapacity + "扩容为:" + newCapacity);
	}



	/**
	 * 移除指定位置的数据
	 * 
	 * @param index
	 * @return 被移除的元素
	 */
	public E remove(int index) {
		E old = elements[index];
		for (int i = index + 1; i < size - 1; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;
		return old;
	}

	/**
	 * 指定元素所在的位置
	 * 
	 * @param element
	 * @return 所在的索引
	 */
	public int indexOf(E element) {
		if (element != null) {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 清除所有数据
	 */
	public void clear() {
		// size置为0 可以重复利用数组
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public String toString() {
		return "ArrayList [size=" + size + ", elements=" + Arrays.toString(elements) + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("gc回收");
		super.finalize();
	}
}
