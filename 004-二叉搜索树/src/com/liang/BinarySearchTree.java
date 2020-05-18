package com.liang;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

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
	
	public TreeNode<E> remove(E element) {
		// 度为0的节点  node.praent.left = null 或者node.parent.right = null
		TreeNode<E> node = node(element);
		if (node == null) {
			return null;
		}
		size--;
		//度为1 左节点: node.parent.left = child; child.parent = node.parent
		//右节点: node.parent.right = child; child.parent = node.parent
		//node是根节点: root = child; child.parent = null
		
		//度为2的节点: 找到node的前驱覆盖node  删除前驱节点
		if (node.hasTwoChildren()) {
			TreeNode<E> preNode = successorNode(node);
			node.element = preNode.element;
			node = preNode;
		}
		
		TreeNode<E> repalcement =  node.left != null ? node.left : node.right;
		if (repalcement != null) { //度为1的节点
			repalcement.parent = node.parent;
			
			if (node.parent == null) {
				root = repalcement;
			}else {
				if (node == node.parent.left) {
					node.parent.left = repalcement;
				}else if (node == node.parent.right) {
					node.parent.right = repalcement;
				}
			}
		}else {
			if (node.parent == null) {
				root = null;
			}else {
				 //node是叶子节点，但不是根节点
				if (node == node.parent.right) {
					node.parent.right = null;
				}else {
					node.parent.left = null;
				}
			}
		}
		
		
		return null;
	}
	
	private TreeNode<E> node(E element) {
		TreeNode<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0) return node;
			if (cmp > 0) {
				node = node.right;
			}else {
				node = node.left;
			}
		}
		return node;
	}
	
	
	/**
	 * 给出一个节点，找到前驱节点
	 * @param node
	 * @return
	 */
	public TreeNode<E> preseesorNode(TreeNode<E> node) {
		//
		if (node == null) {
			return null;
		}
		TreeNode<E> p = node.left;
		if (p != null) { // 在左子树找前驱节点
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		return node.parent; 
	}
	
	/**
	 * 找出指定节点的后继节点
	 * @param node
	 * @return
	 */
	public TreeNode<E> successorNode(TreeNode<E> node) {
		if (node == null) {
			return null;
		}
		TreeNode<E> p = node.right;
		if (p != null) { // 在左子树找前驱节点
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		return node.parent; 
	}
	
	/**
	 * 是否为完全二叉树
	 * @return
	 */
	public boolean isCompleted() {
		//思路  分层遍历，然后判断三种情况
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.offer(root);
		boolean leaf = false;//是否叶子节点
		while (!queue.isEmpty()) {
			TreeNode<E> node = queue.poll();
			if (leaf && !node.isLeaf()) {
				return false;
			}
			if (node.hasTwoChildren()) {
				queue.offer(node.left);
				queue.offer(node.right);
			}else if (node.left == null && node.right != null) {
				return false;
			} else {
				//其他情况
				leaf = true;
			}
		}
		return true;
	}
	
	
	/**
	 * 层序遍历的方法求高度
	 * @return
	 */
	public int height() {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.offer(root);
		// 思路：每一层的个数levelSize出栈后 层数height+1 然后下一层的size = 队列的size
		int height = 0;
		int levelSize = 1;
		while (!queue.isEmpty()) {
			TreeNode<E> node = queue.poll();
			levelSize--;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (levelSize == 0) {
				height++;
				levelSize = queue.size();
			}
		}
		return height;
	}


	/**
	 * 递归的方法求树的高度
	 * @return
	 */
	public int height2() {
		return height2(root);
	}
	
	private int height2(TreeNode<E> node) {
		if (node == null) { return 0; }
		return Math.max(height2(node.left), height2(node.right)) + 1;
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
		
		/**
		 * 是否叶子节点
		 * @return
		 */
		public boolean isLeaf() {
			return this.left == null && this.right == null;
		}
		
		public boolean hasTwoChildren() {
			return this.left != null && this.right != null;
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
		root.left = null;
		root.right = null;
		root = null;
		size = 0;
			
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
