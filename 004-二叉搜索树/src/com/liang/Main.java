package com.liang;

import java.util.Comparator;

import com.liang.BinarySearchTree.Visitor;
import com.liang.printer.BinaryTrees;

public class Main {

	private static void test2() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3 };
		
		BinarySearchTree<Person> bst = new BinarySearchTree<Person>();
		for (int i = 0; i < data.length; i++) {
			bst.add(new Person(data[i]));
		}
		
		BinaryTrees.print(bst);
	}

	private static void test1() {
		Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3 };

		// TODO Auto-generated method stub
		BinarySearchTree<Integer> bst = new BinarySearchTree<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer p1, Integer p2) {
				// TODO Auto-generated method stub
				return p1 - p2;
			}
		});

		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.println(bst);
		bst.levelOrderTraversal(new Visitor<Integer>(){
			@Override
			public void visit(Integer element) {
				System.out.println("element is: " + element);
				
			}
		});
	}
	
	public static void main(String[] args) {
		test1();
	}


}
