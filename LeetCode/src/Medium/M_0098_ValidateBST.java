package Medium;
import java.util.Stack;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class M_0098_ValidateBST {

	TreeNode prev = null;

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		if (!isValidBST(root.left))
			return false;

		if (prev != null && root.val <= prev.val)
			return false;
		prev = root;

		if (!isValidBST(root.right))
			return false;

		return true;
	}

	public boolean isValidBSTApproach2(TreeNode root) {
		// Base Case
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (prev != null && curr.val <= prev.val)
				return false;
			prev = curr;
			curr = curr.right;
		}
		return true;
	}

	public static void main(String[] args) {
		M_0098_ValidateBST obj = new M_0098_ValidateBST();

		TreeNode root = TreeNode.constructBst(new int[] { 1, 2, 3 });
		System.out.println(obj.isValidBST(root));
	}
}
