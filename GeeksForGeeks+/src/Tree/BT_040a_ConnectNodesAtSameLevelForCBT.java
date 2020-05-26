package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level/
 * Time Complexity: O(n) 
 */

public class BT_040a_ConnectNodesAtSameLevelForCBT {
	SpecialTreeNode root;
	
	public class SpecialTreeNode{
		int data;
		SpecialTreeNode left;
		SpecialTreeNode right;
		SpecialTreeNode nextRight;
		public SpecialTreeNode(int x){
			data = x;
			this.left = null;
			this.right = null;
			this.nextRight = null;
		}
	}
	
	// Sets the nextRight of root and calls connectRecur() for other nodes
	public void connect(SpecialTreeNode p) {

		// Set the nextRight for root
		p.nextRight = null;

		// Set the next right for rest of the nodes (other than root)
		connectRecur(p);
	}

	/* Set next right of all descendents of p.
       Assumption:  p is a compete binary tree */
	public void connectRecur(SpecialTreeNode p) {
		// Base case
		if (p == null)
			return;

		// Set the nextRight pointer for p's left child
		if (p.left != null)
			p.left.nextRight = p.right;

		// Set the nextRight pointer for p's right child
		// p->nextRight will be NULL if p is the right most child 
		// at its level
		if (p.right != null) 
			p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null;

		// Set nextRight for other nodes in pre order fashion
		connectRecur(p.left);
		connectRecur(p.right);
	}
	public static void main(String[] args) {
		BT_040a_ConnectNodesAtSameLevelForCBT tree = new BT_040a_ConnectNodesAtSameLevelForCBT();

		/* Constructed binary tree is
	             10
	            /  \
	          8     2
	         /
	        3
		 */
		tree.root = tree.new SpecialTreeNode(10);
		tree.root.left = tree.new SpecialTreeNode(8);
		tree.root.right = tree.new SpecialTreeNode(2);
		tree.root.left.left = tree.new SpecialTreeNode(3);

		// Populates nextRight pointer in all nodes
		tree.connect(tree.root);

		// Let us check the values of nextRight pointers
		System.out.println("Following are populated nextRight pointers in "
				+ "the tree" + "(-1 is printed if there is no nextRight)");
		int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.data + " is "+ a);
		int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.left.data + " is "+ b);
		int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.right.data + " is "+ c);
		int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.left.left.data + " is "+ d);
	}
}
