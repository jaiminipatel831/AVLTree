
public class AVLTree {
	private AvlNode root;



	public void insert(int data) {
		AvlNode n = new AvlNode(data);
		insertHelper(this.root, n);
	}


	public void insertHelper(AvlNode rootNode, AvlNode newNode) {
		
		if (rootNode == null) {
			this.root = newNode;
		} else {
			
			if (newNode.data < rootNode.data) {
				if (rootNode.left == null) {
					rootNode.left = newNode;
					newNode.parent = rootNode;
					
					recursiveBalance(rootNode);
				} else {
					insertHelper(rootNode.left, newNode);
				}
			} else if (newNode.data >= rootNode.data) 
			{
				if (rootNode.right == null) {
					rootNode.right = newNode;
					newNode.parent = rootNode;

					
					recursiveBalance(rootNode);
				} else {
					insertHelper(rootNode.right, newNode);
				}
			}
		}
	}
	

	private int height(AvlNode rootNode) {
		if (rootNode == null) {
			return 0;
		}
		return rootNode.height();
	}

	
	public void recursiveBalance(AvlNode currentNode) {

		int balance = currentNode.getBalance();

		
		if (balance == -2) {

			if (height(currentNode.left.left) >= height(currentNode.left.right)) {
				currentNode = rotateRight(currentNode);
			} else {
				currentNode = doubleRotateLeftRight(currentNode);
			}
		} else if (balance == 2) {
			if (height(currentNode.right.right) >= height(currentNode.right.left)) {
				currentNode = rotateLeft(currentNode);
			} else {
				currentNode = doubleRotateRightLeft(currentNode);
			}
		}

		if (currentNode.parent != null) {
			recursiveBalance(currentNode.parent);
		} else {
			this.root = currentNode;
		}
	}
	
	
	public AvlNode rotateLeft(AvlNode currentNode) {

		AvlNode leftNode = currentNode.right;
		leftNode.parent = currentNode.parent;

		currentNode.right = leftNode.left;

		if (currentNode.right != null) {
			currentNode.right.parent = currentNode;
		}

		leftNode.left = currentNode;
		currentNode.parent = leftNode;

		if (leftNode.parent != null) {
			if (leftNode.parent.right == currentNode) {
				leftNode.parent.right = leftNode;
			} else if (leftNode.parent.left == currentNode) {
				leftNode.parent.left = leftNode;
			}
		}

		return leftNode;
	}


	public AvlNode rotateRight(AvlNode currentNode) {

		AvlNode leftNode = currentNode.left;
		leftNode.parent = currentNode.parent;

		currentNode.left = leftNode.right;

		if (currentNode.left != null) {
			currentNode.left.parent = currentNode;
		}

		leftNode.right = currentNode;
		currentNode.parent = leftNode;

		if (leftNode.parent != null) {
			if (leftNode.parent.right == currentNode) {
				leftNode.parent.right = leftNode;
			} else if (leftNode.parent.left == currentNode) {
				leftNode.parent.left = leftNode;
			}
		}

		return leftNode;
	}

	
	public AvlNode doubleRotateLeftRight(AvlNode currentNode) {
		currentNode.left = rotateLeft(currentNode.left);
		return rotateRight(currentNode);
	}

	
	public AvlNode doubleRotateRightLeft(AvlNode currentNode) {
		currentNode.right = rotateRight(currentNode.right);
		return rotateLeft(currentNode);
	}
	

	private void inorder(AvlNode r) 
	{
		
		if (r == null) {
			return;
		}
		
		inorder(r.left);
		
		System.out.print(r.data + " ");
		
		inorder(r.right);
	}

	
	public void inorder() {
		inorder(root);
	}
	
	
	public boolean isBalancedTree(AvlNode r){
		if (r == null){ 
			return true;
		}
		
		
		int h1 = height(r.left);
		int h2 = height(r.right);
		
		if (Math.abs(h1 - h2) > 1){
			return false;
		}
		
		
		return isBalancedTree(r.left) && isBalancedTree(r.right);				
	}
	
	
	public boolean isBalancedTree(){
		return isBalancedTree(root);
	}
}
