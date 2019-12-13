
public class ArrayList {
	
	private int size;
	private int[] elements;
	
	
	/**
	 * 默认的数组大小
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	
	public ArrayList(int size) {	
		size = size < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : size;
		elements = new int[size];
	}
	
	public ArrayList() {
		elements = new int[DEFAULT_CAPACITY];
	}

	/**
	 * 获取数组的大小 
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 数组是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 是否包含指定的元素
	 * @param element
	 * @return
	 */
	public boolean contains(int element) {
		for (int i = 0; i < size; i++) {
			if(elements[size] == element) return true;
		}
		return false;
	}
	
	/**
	 * 添加元素
	 * @param element
	 */
	public void add(int element) {
		
	}
	
	/**
	 * 获取指定索引的元素
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if (index <= size) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		return elements[index];
	}
	
	/**
	 * 设置指定位置的数据
	 * @param index
	 * @param element
	 * @return 指定位置的原始数据
	 */
	public int set(int index, int element) {
		if (index <= size) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		int old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/**
	 * 在指定位置添加数据
	 * @param index
	 * @param element
	 */
	public void add(int index, int element) {
		
	}
	
	/**
	 * 移除指定位置的数据
	 * @param index
	 * @return 被移除的元素
	 */
	public int remove(int index) {
		return 0;
	}
	
	/**
	 * 指定元素所在的位置
	 * @param element
	 * @return 所在的索引
	 */
	public int indexOf(int element) {
		return 0;
	}
	
	/**
	 * 清除所有数据
	 */
	public void clear() {
		//size置为0 可以重复利用数组
		size = 0;
	}
	
	
	
}
