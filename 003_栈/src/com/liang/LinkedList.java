package com.liang;

/**
 * 双向链表
 * @author michaelyang
 *
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E>{
	
	private Node<E> first; //指向头结点的指针
	private Node<E> last; //尾结点
	
	private static class Node<E>{
		
		private E element;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E element, Node<E> next, Node<E> prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder string = new StringBuilder();
			if (prev != null) {
				string.append(prev.element);
			}else {
				string.append("null");
			}
			
			string.append("_").append(element).append("_");
			
			if (next != null) {
				string.append(next.element);
			}else {
				string.append("null");
			}
			
			return string.toString();
		}
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		if (index == size) {
			Node<E> oldLast = last;
			last = new Node<E>(element, null, oldLast);
			if (oldLast == null) {//链表添加的第一个元素
				first = last;
			}else {
				//链表添加的最后一个元素
				oldLast.next = last;
			}
		}else {
			//中间位置
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<E>(element, next, prev);
			next.prev = node;
			
			if (prev == null) {
				first = node;
			}else {
				prev.next = node;
			}
		}
		size++;
	}

	@Override
	public E remove(int index) {
		
		rangeCheckForAdd(index);
		
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (prev == null) {
			//删除的是头结点
			first = next;
		}else {
			prev.next = next;
		}
		
		if (next == null) {
			//删除的是尾结点
			last = prev;
		}else {
			next.prev = prev;		
		}
		size--;
		return node.element;
	}

	@Override
	public E get(int index) {	
		return node(index).element;
	}

	@Override
	public void set(int index, E element) {
		Node<E> node = node(index);
		node.element = element;
	}
	
	private Node<E> node(int index) {
		rangeCheck(index);
		if (index < (size >> 1)) {
			//从头开始找
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
		
	}

	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) {
					return i;
				}
				node = node.next;
			}
		}
		return List.ELEMENT_NOT_FOUND;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(node);
			node = node.next;
		}
		string.append("]");
		return string.toString();	
	}
}
