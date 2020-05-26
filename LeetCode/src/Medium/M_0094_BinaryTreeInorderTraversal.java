package Medium;
import java.util.*;
import Easy.*;
import Helper.TreeNode;
import Helper.TreeTraversal;
/*
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class M_0094_BinaryTreeInorderTraversal {

	// recursive
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root ==  null) return res;

		inorderTraversalHelper(root, res);
		return res;
    }
	public void inorderTraversalHelper(TreeNode root, List<Integer> res) {
		if(root == null) return;
		inorderTraversalHelper(root.left, res);
		res.add(root.val);
		inorderTraversalHelper(root.right, res);
    }
	public static void main(String[] args) {
		M_0094_BinaryTreeInorderTraversal obj = new M_0094_BinaryTreeInorderTraversal();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(obj.inorderTraversal(root));
		// Iterative
		TreeTraversal.inOrderTraversal(root);
	}
}
