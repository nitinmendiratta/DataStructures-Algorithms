package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/symmetric-tree/
 */
public class E_0101_SymmetricTree {

	/*Time complexity : O(n)O(n). Because we traverse the entire input tree once, 
	 * the total run time is O(n)O(n), where nn is the total number of nodes in the tree.
	 * Space complexity : There is additional space required for the search queue. 
	 * In the worst case, we have to insert O(n)O(n) nodes in the queue. Therefore, space complexity is O(n)O(n).
	 */
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if (t1 == null && t2 == null) continue;
			if (t1 == null || t2 == null) return false;
			if (t1.val != t2.val) return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}
	public boolean isSymmetricApproach2(TreeNode root) {
		return isSymmetric(root, root);
	}

	public boolean isSymmetric(TreeNode a, TreeNode b){
		if(a == null && b == null) return true;
		if(a == null || b == null) return false;
		return (a.val == b.val) && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
	}
	public static void main(String[] args) {
		E_0101_SymmetricTree obj = new E_0101_SymmetricTree();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(obj.isSymmetric(root));
	}
}
