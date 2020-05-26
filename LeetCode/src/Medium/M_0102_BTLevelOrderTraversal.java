package Medium;
import java.util.*;
import Helper.*;
/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class M_0102_BTLevelOrderTraversal {


	public static void main(String[] args) {
		M_0102_BTLevelOrderTraversal obj = new M_0102_BTLevelOrderTraversal();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = TreeTraversal.levelOrderTraversal(root);
		
		for(List<Integer> temp : res) {
			System.out.println(temp);
		}
	}
}
