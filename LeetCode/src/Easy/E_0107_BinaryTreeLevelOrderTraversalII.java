package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class E_0107_BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList();
		if (root == null) return ans;

		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		int level = 0;

		while (!(q.isEmpty()) ) {
			ans.add(new ArrayList());

			int levelSize = q.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode cur = q.remove();
				ans.get(level).add(cur.val);

				if(cur.left != null) q.add(cur.left);
				if(cur.right != null) q.add(cur.right);
			}
			level++;
		}
		Collections.reverse(ans);
		return ans;
	}
	
	// using recursion
	public List<List<Integer>> levelOrderBottomApproach2(TreeNode root) {
		List<List<Integer>> result = new ArrayList();
		levelOrderBottomHelper(root, result, 1);
		return result;
	}

	public void levelOrderBottomHelper(TreeNode root, List<List<Integer>> result, int depth) {
		if (root == null)  return;
		List<Integer> list;
		// means list already available for current level
		if (result.size() < depth) {
			list = new ArrayList<Integer>();
			result.add(0, list);
		} else {
			list = result.get(result.size() - depth);
		}
		list.add(root.val);
		levelOrderBottomHelper(root.left, result, depth+1);
		levelOrderBottomHelper(root.right, result, depth+1);
	}

	public static void main(String[] args) {
		E_0107_BinaryTreeLevelOrderTraversalII obj = new E_0107_BinaryTreeLevelOrderTraversalII();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = obj.levelOrderBottom(root);
		for(List a : result){
			System.out.println(a);
		}
		System.out.println();
		List<List<Integer>> result2 = obj.levelOrderBottomApproach2(root);
		for(List a : result2){
			System.out.println(a);
		}
	}
}
