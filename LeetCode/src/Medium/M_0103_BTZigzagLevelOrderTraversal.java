package Medium;
import java.util.*;
import Helper.*;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class M_0103_BTZigzagLevelOrderTraversal {

	// Iterative
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		boolean zigzag = false;

		while (!queue.isEmpty()) {

			int len = queue.size(), level = 0;
			List<Integer> curr = new ArrayList();

			while (level < len) {
				TreeNode cur = queue.remove();

				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);

				if (zigzag) {
					curr.add(0, cur.val);
				} else
					curr.add(cur.val);
				level++;
			}
			res.add(curr);
			zigzag = !zigzag;
		}
		return res;
	}

	// DFS recursively
	public List<List<Integer>> levelOrderApproach2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		levelHelper(res, root, 0);
		return res;
	}

	public void levelHelper(List<List<Integer>> res, TreeNode node, int level) {
		if (node == null)
			return;
		if (level == res.size()) {
			res.add(new LinkedList<Integer>());
		}

		if (level % 2 == 1) {
			res.get(level).add(0, node.val); // insert at the beginning
		} else {
			res.get(level).add(node.val);
		}
		levelHelper(res, node.left, level + 1);
		levelHelper(res, node.right, level + 1);
	}

	// DFS iteratively
	// import javafx.util.Pair;
	public List<List<Integer>> zigzagLevelOrderApproach3(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
//		Deque<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//		stack.push(new Pair(root, 0));
//		
//		while (!stack.isEmpty()) {
//			Pair<TreeNode, Integer> p = stack.pop();
//			TreeNode node = p.getKey();
//			int l = p.getValue();
//			if (node != null) {
//				if (l == ret.size()) {
//					ret.add(new ArrayList<>());
//				}
//				if (l % 2 == 1) {
//					ret.get(l).add(0, node.val);
//				} else {
//					ret.get(l).add(node.val);
//				}
//				stack.push(new Pair(node.right, l + 1));
//				stack.push(new Pair(node.left, l + 1));
//			}
//		}
		return ret;
	}

	public static void main(String[] args) {
		M_0103_BTZigzagLevelOrderTraversal obj = new M_0103_BTZigzagLevelOrderTraversal();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = obj.zigzagLevelOrder(root);

		for (List<Integer> temp : res) {
			System.out.println(temp);
		}
	}

}
