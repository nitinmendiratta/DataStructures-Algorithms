package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 * Time Complexity: O(n)
 */
public class BT_043_VerticalSumOfBinaryTree {

	// A wrapper over VerticalSumUtil()
	public void VerticalSum(TreeNode root) {

		// base case
		if (root == null) { return; }

		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		// Calls the VerticalSumUtil() to store the 
		// vertical sum values in hM
		VerticalSumUtil(root, 0, hM);

		// Prints the values stored by VerticalSumUtil()
		if (hM != null) {
			System.out.println(hM.entrySet());
		}
	}

	// Traverses the tree in Inoorder form and builds
	// a hashMap hM that contains the vertical sum
	private void VerticalSumUtil(TreeNode root, int hD, HashMap<Integer, Integer> hM) {

		// base case
		if (root == null) {  return; }

		// Store the values in hM for left subtree
		VerticalSumUtil(root.left, hD - 1, hM);

		// Update vertical sum for hD of this node
		int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
		hM.put(hD, prevSum + root.data);

		// Store the values in hM for right subtree
		VerticalSumUtil(root.right, hD + 1, hM);
	}
	public static void main(String[] args) {
		BT_043_VerticalSumOfBinaryTree obj = new BT_043_VerticalSumOfBinaryTree();
		/* Create following Binary Tree
	          1
	        /    \
	      2        3
	     / \      / \
	    4   5    6   7

		 */
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println("Following are the values of" + 
				" vertical sums with the positions" +
				" of the columns with respect to root ");
		obj.VerticalSum(root);
	}

}
