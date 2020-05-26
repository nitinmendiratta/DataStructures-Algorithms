package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
 * Time Complexity: O(n) and constant space
 */

public class BT_040bConnectNodesAtSameLevelForCBTConstantSpace {
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

	/* This function returns the leftmost child of nodes at the same level
    as p. This function is used to getNExt right of p's right child
    If right child of is NULL then this can also be sued for the left child */
	SpecialTreeNode getNextRight(SpecialTreeNode p){
		SpecialTreeNode temp = p.nextRight;

		/* Traverse nodes at p's level and find and return
        the first SpecialTreeNode's first child */
		while (temp != null) {
			if (temp.left != null)
				return temp.left;
			if (temp.right != null)
				return temp.right;
			temp = temp.nextRight;
		}

		// If all the nodes at p's level are leaf nodes then return NULL
		return null;
	}

	/* Sets nextRight of all nodes of a tree with root as p */
	public void connect(SpecialTreeNode p) {
		SpecialTreeNode temp = null;

		if (p == null)
			return;

		// Set nextRight for root
		p.nextRight = null;

		// set nextRight of all levels one by one
		while (p != null){
			SpecialTreeNode q = p;

			/* Connect all childrem nodes of p and children nodes of all other
            nodes at same level as p */
			while (q != null){
				// Set the nextRight pointer for p's left child
				if (q.left != null){

					// If q has right child, then right child is nextRight of
					// p and we also need to set nextRight of right child
					if (q.right != null)
						q.left.nextRight = q.right;
					else
						q.left.nextRight = getNextRight(q);
				}

				if (q.right != null)
					q.right.nextRight = getNextRight(q);

				// Set nextRight for other nodes in pre order fashion
				q = q.nextRight;
			}

			// start from the first SpecialTreeNode of next level
			if (p.left != null)
				p = p.left;
			else if (p.right != null)
				p = p.right;
			else
				p = getNextRight(p);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		/* Constructed binary tree is
              10
            /   \
          8      2
        /         \
      3            90
		 */
		BT_040bConnectNodesAtSameLevelForCBTConstantSpace tree = new BT_040bConnectNodesAtSameLevelForCBTConstantSpace();
		tree.root = tree.new SpecialTreeNode(10);
		tree.root.left = tree.new SpecialTreeNode(8);
		tree.root.right = tree.new SpecialTreeNode(2);
		tree.root.left.left = tree.new SpecialTreeNode(3);
		tree.root.right.right = tree.new SpecialTreeNode(90);

		// Populates nextRight pointer in all nodes
		tree.connect(tree.root);

		// Let us check the values of nextRight pointers
		int a = tree.root.nextRight != null ? 
				tree.root.nextRight.data : -1;
		int b = tree.root.left.nextRight != null ? 
				tree.root.left.nextRight.data : -1;
		int c = tree.root.right.nextRight != null ? 
				tree.root.right.nextRight.data : -1;
		int d = tree.root.left.left.nextRight != null ? 
				tree.root.left.left.nextRight.data : -1;
		int e = tree.root.right.right.nextRight != null ? 
				tree.root.right.right.nextRight.data : -1;

		// Now lets print the values
		System.out.println("Following are populated nextRight pointers in "
				+ " the tree(-1 is printed if there is no nextRight)");
		System.out.println("nextRight of " + tree.root.data + " is " + a);
		System.out.println("nextRight of " + tree.root.left.data 
				+ " is " + b);
		System.out.println("nextRight of " + tree.root.right.data + 
				" is " + c);
		System.out.println("nextRight of " + tree.root.left.left.data + 
				" is " + d);
		System.out.println("nextRight of " + tree.root.right.right.data + 
				" is " + e);
	}
}
