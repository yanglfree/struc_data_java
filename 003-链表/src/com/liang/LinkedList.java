package com.liang;

public class LinkedList<E> extends AbstractList<E>{
	
	private int size;
	private Node first;
	
	private static class Node<E>{
		E element;
		Node nextNode;
		
		public Node(E element, Node nextNode) {
			this.element = element;
			this.nextNode = nextNode;
		}
	}

	@Override
	public void clear() {
		// 
		first = null;
		size = 0;
		
	}
	
	public void add(int index, E element) {
		
	}
	
	private Node<E> node(int index){
		
	}
	
	
	

}
