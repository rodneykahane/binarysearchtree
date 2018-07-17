package binarysearchtree;

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
	
	
	public void deleteNode(int key) {
		Node current = root;
		Node parent;
		Node childR;
		Node childL;
		
		while(true) {
			parent = current;
			if(key < current.key) {
				current = current.leftChild;
				if(current.key == key) {
					childR=current.rightChild;
					childL=current.leftChild;
					parent.leftChild = null;
					if(childR != null) {
						insert(childR.key,childR.value);
					}
					if(childL != null) {
						insert(childL.key,childL.value);
					}
					
					return;
				}
			} else {
				current = current.rightChild;
				if(current.key == key) {
					childR=current.rightChild;
					childL=current.leftChild;
					parent.rightChild = null;
					if(childR != null) {
						insert(childR.key,childR.value);
					}
					if(childL != null) {
						insert(childL.key,childL.value);
					}
					return;
				}
			}
		}//end while
	}//end deleteNode()
	
}//end class
