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
		/*tree.insert(10,"TEN");		
		tree.insert(5,"five");
		tree.insert(3,"three");
		tree.insert(7,"seven");*/
		
		
		/*tree.insert(8,"eight");		
		tree.insert(4,"four");
		tree.insert(2,"two");
		tree.insert(1,"one");
		tree.insert(6,"six");*/
		
		/*System.out.println(tree.findMin().key);
		System.out.println(tree.findMax().key);*/
		
		/*tree.insert(80,"eighty");
		tree.insert(52,"fifty two");
		tree.insert(48,"forty eight");
		tree.insert(71,"seventy one");
		tree.insert(63,"sixty three");
		tree.insert(67,"sixty seven");*/
		
		tree.insert(50,"fifty");
		tree.insert(25,"twenty five");
		tree.insert(15,"fifteen");
		tree.insert(35,"thirty five");
		tree.insert(5,"five");
		tree.insert(20,"twenty");
		tree.insert(30,"thirty");
		tree.insert(40,"forty");
		
		
		
		tree.listNode(50);
		System.out.println("");		
		tree.listNode(25);
		System.out.println("");
		tree.deleteNode(25);		
		
		tree.listNode(50);
		System.out.println("");
		//tree.listNode(63);
		//.out.println("");
		//tree.listNode(67);

	}//end main

}//end class
