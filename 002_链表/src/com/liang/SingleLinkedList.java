package com.liang;


public class SingleLinkedList<E> extends AbstractList<E>{
	
	private Node first;
	
	private static class Node<E>{
		E element;
		Node next;
		
		public Node(E element, Node next) {
			this.element = element;
			this.next = next;
		}	
		
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
	}

	@Override
	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) { return i; }
				node = node.next;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) {return i;}
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> node = first;
		if (index == 0) {
			first = first.next;
		}else {		
			Node<E> pre = node(index - 1);
			node = pre.next;
			pre.next = pre.next.next;
		}
		size--;
		return node.element;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		if (index == 0) {
			first = new Node<>(element, first);
		}else {
			Node<E> pre = node(index - 1);
			pre.next = new Node<>(element, pre.next);
		}
		size++;
	}

	@Override
	public E set(E element, int index) {
		Node<E> oldNode = node(index);
		Node<E> newNode = oldNode;
		newNode.element = element;
		return oldNode.element;
	}

	@Override
	public E get(int index) {	
		Node<E> node = node(index); 
		return node.element;
	}
	
	
	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("size is: "+ size + ", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sb.append(", ");
			}
			sb.append(node.element);
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}

}
