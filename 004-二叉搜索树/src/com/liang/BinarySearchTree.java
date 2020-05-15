package com.liang;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.liang.printer.BinaryTreeInfo;

/**
 * 二叉搜索树
 * @author michaelyang
 *
 */
public class BinarySearchTree<E> implements BinaryTreeInfo{
	
	private int size;
	private TreeNode<E> root;
	private Comparator<E> comparator;
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public BinarySearchTree() {
		this(null);
	}
	
	/**
	 * 前序遍历
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
	}
	
	private void preorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	/**
	 * 中序遍历
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left);
		System.out.println(node.element);
		inorderTraversal(node.right);
	}
	
	/**
	 * 后序遍历
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
	}
	
	private void postorderTraversal(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.element);
	}
	
	public static interface Visitor<E>{
		void visit(E element);
	}
	
	/**
	 * 层序遍历
	 * @param visitor
	 */
	public void levelOrderTraversal(Visitor<E> visitor) {
		if (visitor == null) { return; }
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode<E> node = queue.poll();
			visitor.visit(node.element);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(TreeNode<E> node) {
		if (node == null) { return 0; }
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	private static class TreeNode<E>{
		E element;
		TreeNode<E> left;
		TreeNode<E> right;
		TreeNode<E> parent;
		public TreeNode(E element, TreeNode<E> parent) {
			this.element = element;
			this.parent = parent;		
		}
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("Element can not be null");
		}
	}
	
	public boolean isEmpty() {
	
		return size == 0;
	}
	
	public void clear() {
		
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		
		//添加的是第一个节点
		if (root == null) {
			root = new TreeNode<>(element, null);
			size++;
			return;
		}
		
		//添加的不是第一个节点
		//添加步骤： 1 找到父节点parentNode 2、创建新节点node 3、parent.left = node 或者parent.right = node
		TreeNode<E> node = root;
		TreeNode<E> parent = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			}else if (cmp < 0) {
				node = node.left;
			}else {
				node.element = element;
				return;
			}
		}
		
		//创建新的节点
		TreeNode<E> newNode = new TreeNode<>(element, parent);
		
		//设置新节点为父节点的左节点或右节点
		if (cmp > 0) {
			parent.right = newNode;
		}else{
			parent.left = newNode;
		}
		size++;
	}
	
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	public void remove(E element) {
		
	}
	
	public boolean contains(E element) {
		
		return false;
	}

	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object left(Object node) {
		// TODO Auto-generated method stub
		return ((TreeNode<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return ((TreeNode<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		// TODO Auto-generated method stub
		return ((TreeNode<E>)node).element;
	}

}
