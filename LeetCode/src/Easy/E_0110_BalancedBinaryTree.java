package Easy;

import Helper.TreeNode;

/*
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 */
public class E_0110_BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if(checkHeight(root) == -1) return false;
		return true;
	}

	public int checkHeight(TreeNode root){

		if(root == null) return 0;

		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1) return -1;

		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1) return -1;

		if(Math.abs(leftHeight - rightHeight) > 1) return -1;
		return (1+ Math.max(leftHeight,rightHeight));
	}

	public static void main(String[] args) {
		/*E_0110_BalancedBinaryTree obj = new E_0110_BalancedBinaryTree();
		// Create balanced tree
		CreateMinBstFromAnArray_3 obj2 = new CreateMinBstFromAnArray_3();
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = obj2.createMinimalBST(array,0,9);
		System.out.println("Root: " + root.data);
		System.out.println("Is balanced: " + obj.isBalanced(root));*/
	}
}
