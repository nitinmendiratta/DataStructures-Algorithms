package Tree;
/*
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
 * Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.
 */
public class BT_036_PrintAncestorsOfaNodeInBinaryTree {
	
	public static boolean printAncestors(TreeNode root, int x){
		if(root == null) return false;
		
		if(root.data == x)
			return true;

		if(printAncestors(root.left,x) || printAncestors(root.right,x)){
			System.out.print(root.data+",");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		printAncestors(root,7);
	}
}
