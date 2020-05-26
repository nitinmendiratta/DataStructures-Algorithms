package Tree;
/*
 * http://www.geeksforgeeks.org/double-tree/
 * Time Complexity: O(n) where n is the number of nodes in the tree.
 */
public class BT_031_DoubleTree {

	public static void doubleTree(TreeNode root){
		if(root == null) return;
		TreeNode temp;
		TreeNode newNode = new TreeNode(root.data);
		temp = root.left;
		root.left = newNode;
		newNode.left = temp;
		doubleTree(root.left.left);
		doubleTree(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.print(root);
		doubleTree(root);
		System.out.println();
		root.print(root);
	}
}
