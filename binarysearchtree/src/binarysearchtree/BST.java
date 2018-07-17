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



	public void listNode(int key) {
		Node current = root;
		Node parent=null;

		while(true) {

			if(key<current.key) {
				parent = current;			
				current = current.leftChild;
			} else if (key > current.key){
				parent = current;
				current = current.rightChild;
			} else if (current.key == key) {
				current.displayNode();
				if(current != root) {
					System.out.println("my parent is "+parent.key);
				}

				if(current.leftChild != null) {
					current.leftChild.displayChildL();
				} 
				if (current.rightChild != null) {
					current.rightChild.displayChildR();
				}  
				if(current.rightChild == null) {
					System.out.println("i dont have a right child");
				}  
				if(current.leftChild == null) {
					System.out.println("i dont have a left child");
				}
				return;
			} else {
				System.out.println("couldnt find that key");
				return;
			}

		}//end while
	}//end listNode

}//end class
