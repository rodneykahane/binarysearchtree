package binarysearchtree;

public class Application {

	public static void main(String[] args) {

		BST tree = new BST();
		/*
		tree.insert(10,"TEN");
		tree.insert(20,"twenty");
		tree.insert(15,"fifteen");


		System.out.println(tree.findMin().key);
		System.out.println(tree.findMax().key);

*/		
		tree.insert(10,"TEN");		
		tree.insert(5,"five");
		tree.insert(3,"three");
		tree.insert(7,"seven");
		
		
		tree.insert(8,"eight");		
		tree.insert(4,"four");
		tree.insert(2,"two");
		tree.insert(1,"one");
		tree.insert(6,"six");
		
		/*System.out.println(tree.findMin().key);
		System.out.println(tree.findMax().key);*/
		
		tree.listNode(5);
		tree.deleteNode(5);
		System.out.println("");
		
		tree.listNode(10);
		

	}//end main

}//end class
