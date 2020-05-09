package com.liang;

public interface List<E> {
	
	/**
	 * 获取数组的大小
	 * 
	 * @return 
	 */
	int size();

	/**
	 * 数组是否为空
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 清除所有数据
	 */
	void clear();
	
	/**
	 * 是否包含指定的元素
	 * 
	 * @param element
	 * @return
	 */
	boolean contains(E element);

}
