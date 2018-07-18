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
			//traversing through the left branch
			if(key < current.key) {
				current = current.leftChild;
				if(current.key == key) {
					//version 1
					/*childR=current.rightChild; 
					childL=current.leftChild; 
					parent.leftChild = current.leftChild;
					if(childR != null) {
						parent.leftChild = childL;
					}
					if(childL != null) {
						parent.rightChild = childR;
					}*/
					//version 2
					/*if(current.leftChild != null && current.rightChild != null) {						
						parent.leftChild = current.leftChild;
						parent.rightChild = current.rightChild;
					} else if(current.leftChild == null){					
						parent.leftChild = current.rightChild;
					}*/
					//version 3 <-- does not consider additional child nodes :(					
					/*childR=current.rightChild;
					childL=current.leftChild;
					if(childL.key > childR.key) {
						parent.leftChild=childL;
						childR.leftChild.leftChild = childR;
					} else {
						parent.leftChild = childR;
						childR.leftChild.leftChild = childL;
					}*/
					//version 4
					

					return;
				}
			} 
			//traversing through the right branch
			if(key > current.key){
				current = current.rightChild;
				if(current.key == key) {
					//version 1
					/*childR=current.rightChild;
					childL=current.leftChild;
					parent.rightChild = current.rightChild;
					if(childR != null) {
						insert(childR.key,childR.value);
					}
					if(childL != null) {
						insert(childL.key,childL.value);
					}*/
					//version 2
					/*if(current.rightChild != null && current.leftChild != null) {						
						parent.rightChild = current.rightChild;
						parent.leftChild = current.leftChild;
					} else if (current.rightChild == null){					
						parent.rightChild = current.leftChild;
					}*/
					//version 3 <-- does not consider additional child nodes :(					
					/*childR=current.rightChild;
					childL=current.leftChild;
					if(childR.key > childL.key) {
						parent.rightChild=childR;
						childR.leftChild.leftChild = childL;
					} else {
						parent.rightChild = childL;
						childR.rightChild.rightChild = childL;
					}*/
					//version 4
					
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
