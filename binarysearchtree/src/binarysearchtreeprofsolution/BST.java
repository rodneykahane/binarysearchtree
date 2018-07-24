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

	public boolean remove(int key) {
		Node currentNode = root;
		Node parentNode = root;

		boolean isLeftChild = false;

		//searching to find the node with the key to delete
		while(currentNode.key != key) {
			parentNode = currentNode;
			if(key<currentNode.key) {
				isLeftChild=true;
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
				isLeftChild = false;
			}
			if(currentNode == null) {
				return false;
			}
		}

		//found the node
		Node nodeToDelete = currentNode;


		//if node is a leaf
		if(nodeToDelete.leftChild == null && nodeToDelete.rightChild==null) {
			if(nodeToDelete==root) {
				root = null;
			} else if (isLeftChild) {
				parentNode.leftChild = null;
			} else {
				parentNode.rightChild = null;
			}
		}

		//if node has one child child that is on the left
		else if(nodeToDelete.rightChild == null) {
			if(nodeToDelete == root) {
				root = nodeToDelete.leftChild;
			} else if (isLeftChild) {
				parentNode.leftChild = nodeToDelete.leftChild;
			} else {
				parentNode.rightChild = nodeToDelete.leftChild;
			}			
		}

		//if node has one child child that is on the right
		else if(nodeToDelete.leftChild == null) {
			if(nodeToDelete == root) {
				root = nodeToDelete.rightChild;
			} else if (isLeftChild) {
				parentNode.leftChild = nodeToDelete.rightChild;
			} else {
				parentNode.rightChild = nodeToDelete.rightChild;

			}			
		}

		//if node has 2 children
		else {
			Node successor = getSuccessor(nodeToDelete);
			//connect parent of lead to successor

			if(nodeToDelete == root) {
				root = successor;
			} else if(isLeftChild) {
				parentNode.leftChild = successor;
			} else {
				parentNode.rightChild = successor;
			}

			successor.leftChild = nodeToDelete.leftChild;
		}


		return true;
	}//end remove()

	private Node getSuccessor(Node nodeToDelete) {
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;

		Node current = nodeToDelete.rightChild; // go to the right child

		while(current != null) {  //start going left down the tree until the node has no left children
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		//if successor not a right child
		if(successor != nodeToDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToDelete.rightChild;			
		}

		return successor;
	}//end getSuccessor()

	public static void displayTree(BST tree) {
		Node currentNode = tree.root;
		Node parentNode = tree.root;
		Node currentL;
		Node currentR;
		Node parentL;
		Node parentR;
		int side=0;
		int newLine=0;



		System.out.println("......................................................");
		System.out.println(currentNode.key);
		System.out.print(currentNode.leftChild.key);
		System.out.print("    ");
		System.out.print(currentNode.rightChild.key);
		System.out.println("");
		currentL=parentNode.leftChild;
		currentR= parentNode.rightChild;
		parentL=currentL;
		parentR=currentR;

		while(currentL != null || currentR != null) {
			if(currentL!=null && currentL.leftChild!=null)
				System.out.print(" "+currentL.leftChild.key);
			System.out.print("      ");
			if(currentL!=null && currentL.rightChild!=null)
				System.out.print(" "+currentL.rightChild.key);
			System.out.print("      ");
			if(currentR!=null && currentR.leftChild!=null)
				System.out.print(" "+currentR.leftChild.key);
			System.out.print("      ");
			if(currentR!=null&&currentR.rightChild!=null)
				System.out.print(" "+currentR.rightChild.key);




			if(newLine == 2) {				

				parentL=parentL.rightChild;
				parentR=parentR.rightChild;
				newLine=0;

				currentL=parentL.leftChild;
				currentR=parentL.rightChild;
				if(currentL!=null) {
					int debugKey_pLlC= currentL.key;
				}
				if(currentR!=null) {
					int debugKey_pLrC = currentR.key;
				}
				//System.out.println("*** side is "+side+" parentL is "+parentL.key+" parentR is "+parentR.key+" currentL is "+currentL.key+" currentR is "+currentR.key);
				side++;
				newLine++;
				System.out.println("");

			} else if(side == 0) {				
				System.out.println("");
				currentL=parentL.leftChild;
				currentR=parentL.rightChild;
				int debugKey_pLlC= currentL.key;
				int debugKey_pLrC = currentR.key;
				//System.out.println("*** side is "+side+" parentL is "+parentL.key+" parentR is "+parentR.key+" currentL is "+currentL.key+" currentR is "+currentR.key);
				side++;
				newLine++;
			}else if(side == 1){				

				int plkey=parentL.key;
				int prkey = parentR.key;


				currentL=parentR.leftChild;
				currentR=parentR.rightChild;
				if(currentL==null&&currentR.rightChild==null) {
					System.out.println("......................................................");
					break;
				}
				int debugKey_pRlC= currentL.key;
				int debugKey_pRrC = currentR.key;
				//System.out.println("*** side is "+side +" parentL is "+parentL.key+" parentR is "+parentR.key+" currentL is "+currentL.key+" currentR is "+currentR.key);
				side--;
				newLine++;

			}


		}//end while






	}//end displayTree()

	private static void dispNode (Node disp, int tab) {
		for(int i=0;i<tab-1;i++) {
			System.out.print("    ");
		}
		if(disp != null) {
			System.out.print(disp.key);
		} else {
			System.out.print("--");
		}
	}


}//end class
//