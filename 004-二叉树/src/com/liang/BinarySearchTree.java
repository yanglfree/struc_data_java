package com.liang;

import java.util.Comparator;

import com.liang.printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo{
	
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}

	public BinarySearchTree() {
		super();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		//找出需要插入的节点的位置
		Node<E> parent= root;
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			parent = node;
			cmp = compare(element,node.element);
			if (cmp > 0) {
				node = node.right;
			}else if (cmp < 0) {
				node= node.left;
			}else {
				node.element = element;
			}
		}
		
		//插入节点
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		}else {
			parent.left = newNode;
		}
		size++;
	}
	
	private int compare(E element1, E element2) {
		if (comparator != null) {
			return comparator.compare(element1, element2);
		}
		return ((Comparable<E>)element1).compareTo(element2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("Node must not be null");
		}
	}
	
	public E remove() {
		return null;
	}
	
	private static class Node<E>{
		
		E element;
		Node<E> parent;
		Node<E> left;
		Node<E> right;
		
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
	}

	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object left(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).element;
	}
	
}
