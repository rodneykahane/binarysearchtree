package binarysearchtreeprofsolution;

public class BST {

	private Node root;

	public void insert(int key, String value) {

		Node newNode = new Node(key,value);

		if(root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;

			while(true) {
				parent = current;
				if(key < current.key) {
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}//end while
		}		
	}//end insert()

	public Node findMin() {

		Node current = root;
		Node last = null;

		while(current != null) {
			last = current;
			current = current.leftChild;
		}

		return last;
	}//end findMin()

	public Node findMax() {

		Node current = root;
		Node last = null;

		while(current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}//end findMax()

	//when deleting node, find the smallest node in the set of nodes that are large than the one being deleted



}//end class
