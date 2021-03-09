
public class AvlNode {

	protected int data;			
	
	protected AvlNode left;		
	protected AvlNode right;	
	protected AvlNode parent;	
	
	
	public AvlNode(int data) {
		this.data = data;
	}

	
	protected int getBalance() {
		
		int lHeight = (left == null) ? 0 : left.height();
		
		int rHeight = (right == null) ? 0 : right.height();
		
		return rHeight - lHeight;
	}

	
	public String toString() {
		return "" + data;
	}

	
	protected int height() {
		int leftHeight = (left == null) ? 0 : left.height();
		int rightHeight = (right == null) ? 0 : right.height();
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
