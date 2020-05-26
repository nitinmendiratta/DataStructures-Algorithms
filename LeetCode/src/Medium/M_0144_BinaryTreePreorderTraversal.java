package Medium;
import java.util.*;
import Helper.*;
/*
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class M_0144_BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversalRecursive(TreeNode root) {
		return TreeTraversal.preOrderTraversalRecursive(root);
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		return TreeTraversal.preOrderTraversal(root);
	}

	public static void main(String[] args) {
		M_0144_BinaryTreePreorderTraversal obj = new M_0144_BinaryTreePreorderTraversal();
		TreeNode root = TreeNode.createRandomBST(4);
		System.out.println();
		TreeNode.printNode(root);
		System.out.println(obj.preorderTraversal(root));
		System.out.println(obj.preorderTraversalRecursive(root));
	}
}
