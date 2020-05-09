package com.liang;

public class SingleLinkedList<E> extends AbstractList<E>{
	
	private Node<E> first; //指向头结点的指针
	
	private static class Node<E>{
		
		private E element;
		private Node<E> next;
		
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
	}

	@Override
	public void add(int index, E element) {
		
		rangeCheckForAdd(index);
		
		if (index == 0) {
			first = new Node<E>(element, first);
		}else {
			Node<E> preN = node(index - 1);
			preN.next = new Node<E>(element, preN.next);
			size++;
		}
	}

	@Override
	public E remove(int index) {
		
		rangeCheckForAdd(index);
		
		Node<E> node = first;
		if (index == 0) {
			first = first.next;
		}else {
			Node<E> prevNode = node(index - 1);
			node = prevNode.next;
			prevNode.next = prevNode.next.next;
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
		
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
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
		return "LinkedList [first=" + first + "]";
	}
	
	

}
