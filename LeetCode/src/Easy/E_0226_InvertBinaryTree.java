package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class E_0226_InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
	// using stack
	public TreeNode invertTreeApproach2(TreeNode root) {

		if (root == null) {
			return null;
		}

		final Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			final TreeNode node = stack.pop();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if(node.left != null) {
				stack.push(node.left);
			}
			if(node.right != null) {
				stack.push(node.right);
			}
		}
		return root;
	}
	public static void main(String[] args) {
		E_0226_InvertBinaryTree obj = new E_0226_InvertBinaryTree();
		int[] inputArr = new int[]{4,2,7,1,3,6,9};
		TreeNode input = TreeNode.constructCompleteBinaryTree(inputArr);
		TreeNode.print(input);
		System.out.println();
		TreeNode.print(obj.invertTree(input));
	}
}
