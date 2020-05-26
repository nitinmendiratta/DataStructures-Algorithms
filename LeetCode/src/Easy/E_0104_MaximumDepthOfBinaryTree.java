package Easy;

import Helper.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class E_0104_MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return 1 + Math.max(lDepth, rDepth);
	}
	public static void main(String[] args) {
		E_0104_MaximumDepthOfBinaryTree obj = new E_0104_MaximumDepthOfBinaryTree();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(obj.maxDepth(root));
	}

}
