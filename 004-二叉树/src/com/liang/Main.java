package com.liang;

import java.util.Comparator;
import com.liang.printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] datas = new Integer[] {
			7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
//		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//		for (int i = 0; i < datas.length; i++) {
//			bst.add(datas[i]);
//		}
//		
//		
//		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
//		for (int i = 0; i < datas.length; i++) {
//			bst1.add(new Person(datas[i]));;
//		}
		
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		for (int i = 0; i < datas.length; i++) {
			bst2.add(new Person(datas[i]));;
		}
		
		BinaryTrees.println(bst2);

	}

}
