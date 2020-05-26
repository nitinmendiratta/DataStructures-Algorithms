package Medium;
import java.util.*;
import Helper.*;
/*
 * https://leetcode.com/problems/path-sum-ii/
 */
public class M_0113_PathSum2 {

	// Approach1: Recursive
	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> res = new ArrayList();

		pathSumHelper(root, res, new ArrayList(), sum, 0);
		return res;
	}

	public void pathSumHelper(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum, int currSum) {

		if (root == null)
			return;
		currSum += root.val;
		temp.add(root.val);

		if (currSum == sum && root.left == null && root.right == null) {
			res.add(new ArrayList(temp));
		} else {
			pathSumHelper(root.left, res, temp, sum, currSum);
			pathSumHelper(root.right, res, temp, sum, currSum);
		}
		temp.remove(temp.size() - 1);
	}

	// Approach2: Iterative
	public List<List<Integer>> pathSumApproach2(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		List<Integer> path = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();

		// sum along the current path
		int pathSum = 0;
		TreeNode lastVisited = null; // use it to judge whether the right tree has been visited
		TreeNode curr = root;

		while (curr != null || !s.isEmpty()) {
			// go down all the way to the left leaf node
			// add all the left nodes to the stack
			while (curr != null) {
				s.push(curr);
				// record the current path
				path.add(curr.val);
				// record the current sum along the current path
				pathSum += curr.val;
				curr = curr.left;
			}
			// check left leaf node's right subtree
			// or check if it is not from the right subtree
			// why peek here?
			// because if it has right subtree, we don't need to push it back
			curr = s.peek();
			if (curr.right != null && curr.right != lastVisited) {
				curr = curr.right;
				continue; // back to the outer while loop
			}
			// check leaf
			if (curr.left == null && curr.right == null && pathSum == sum) {
				list.add(new ArrayList<Integer>(path));
				// why do we need new arraylist here?
				// if we are using the same path variable path
				// path will be cleared after the traversal
			}
			// pop out the current value
			s.pop();
			lastVisited = curr;
			// subtract current node's val from path sum
			pathSum -= curr.val;
			// as this current node is done, remove it from the current path
			path.remove(path.size() - 1);
			// reset current node to null, so check the next item from the stack
			curr = null;
		}
		return list;
	}

	// Approach 3: Special Node

	class SpecialNode {
		int val = 0;
		TreeNode root = null;
		List<Integer> path = new ArrayList<Integer>();

		public SpecialNode(int _val, TreeNode _root, List<Integer> _path) {
			val = _val;
			root = _root;
			path = new ArrayList<Integer>(_path);
		}

	}

	// dfs iteratively
	public List<List<Integer>> pathSumApproach3(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (root == null)
			return ans;

		Deque<SpecialNode> q = new LinkedList<SpecialNode>();
		q.add(new SpecialNode(0, root, new ArrayList<Integer>()));

		while (!q.isEmpty()) {
			SpecialNode currSpecial = q.pollFirst();
			TreeNode curr = currSpecial.root;
			int temp = currSpecial.val + curr.val;
			List<Integer> path = currSpecial.path;
			path.add(curr.val);

			if (curr.left == null && curr.right == null && temp == sum) {
				ans.add(path);
			}
			if (curr.left != null) {
				q.addLast(new SpecialNode(temp, curr.left, path));
			}
			if (curr.right != null) {
				q.addLast(new SpecialNode(temp, curr.right, path));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		M_0113_PathSum2 obj = new M_0113_PathSum2();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = obj.pathSumApproach3(root, 7);

		for (List<Integer> temp : res) {
			System.out.println(temp);
		}
	}
}
