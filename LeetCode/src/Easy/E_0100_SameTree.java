package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/same-tree/
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 * Complexity of the identicalTree() will be according to the tree with lesser number of nodes. 
 * Let number of nodes in two trees be m and n then complexity of sameTree() is O(m) where m < n
 */
public class E_0100_SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(q == null && p == null) return true;
		if(p != null && q != null){
			return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}
	public boolean isSameTreeApproach2(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.add(p);
		queue2.add(q);

		while (!queue1.isEmpty()) {
			TreeNode node1 = queue1.remove();
			TreeNode node2 = queue2.remove();

			if (node1 == null && node2 != null)
				return false;

			if (node2 == null && node1 != null)
				return false;

			if (node1 != null && node2 != null && node1.val != node2.val)
				return false;

			if(node1 != null) {
				queue1.add(node1.left);
				queue1.add(node1.right);    
			}

			if(node2 != null) {
				queue2.add(node2.left);
				queue2.add(node2.right); 
			}
		}
		return true; 
	}
	public static void main(String[] args) {
		E_0100_SameTree obj = new E_0100_SameTree();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(6);
		root1.right = new TreeNode(2);
		root1.left.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.right.left = new TreeNode(5);
		root1.right.right = new TreeNode(6);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(6);
		root2.right = new TreeNode(2);
		root2.left.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.right.left = new TreeNode(5);
		root2.right.right = new TreeNode(6);

		System.out.println("Identical:"+obj.isSameTree(root1,root2));
		System.out.println("Identical:"+obj.isSameTreeApproach2(root1,root2));
	}
}
