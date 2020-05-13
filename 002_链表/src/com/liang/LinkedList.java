package com.liang;

public class LinkedList<E> extends AbstractList<E>{
	
	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E>{
		E element;
		Node<E> next;
		Node<E> pre;
		
		public Node(E element, Node<E> next, Node<E> pre) {
			this.element = element;
			this.next = next;
			this.pre = pre;
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
		
	}

	@Override
	public int indexOf(E element) {
		return 0;
	}

	@Override
	public E remove(int index) {
		Node<E> node = node(index);
		Node<E> pre = node.pre;
		Node<E> next = node.next;
		
		if (pre == null) { //index == 0
			first = next;
		}else {
			pre.next = next;
		}
		
		if (next == null) { //index == size - 1
			last = pre;
			
		}else {
			next.pre = pre;
		}
		size--;
		return node.element;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		Node<E> node = node(index);
		
		
		if (index == size) {
			Node<E> oldLast = last;
			last = new Node<>(element, null, node);
			
			if (oldLast == null) {
				first = last;
			}else {
				oldLast.next = last;	
			}
		}else {		
			if (index == 0) {
				Node<E> newNode = new Node<>(element, node, null);
				node.pre = newNode;
				first = newNode;
			}else {
				Node<E> newNode = new Node<>(element, node, node.pre);
				node.pre.next = newNode;
				node.pre = newNode;
			}
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
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.pre;
			}
			return node;
		}
		
	}
}
