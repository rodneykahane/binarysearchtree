package binarysearchtree;

public class Node {

	int key;
	String value;
	Node leftChild, rightChild;

	public Node(int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public void displayNode() {		
		System.out.println("my key is " + key);

	}

	public void displayChildL() {		
		System.out.println("my left child key is " + key);

	}
	public void displayChildR() {		
		System.out.println("my right child key is " + key);

	}

}
