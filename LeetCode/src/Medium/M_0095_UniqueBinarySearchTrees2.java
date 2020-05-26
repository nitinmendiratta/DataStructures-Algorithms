package Medium;
import java.util.*;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class M_0095_UniqueBinarySearchTrees2 {

	// https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31552/JAVA-DP-Solution-and-Brute-Force-Recursive-Solution
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<>();
		if (n == 0)
			return res;
		res.add(null);
		
		for (; n > 0; n--) {
			List<TreeNode> next = new ArrayList<>();
			for (TreeNode node : res) {
				// the special case when Node(n) is root of new tree
				TreeNode root = new TreeNode(n);
				root.right = node;
				next.add(root);
				// while loop inserts new value to every possible position into the left tree
				// side
				while (node != null) {
					TreeNode cRoot = new TreeNode(root.right.val);
					// clone left subtree
					cRoot.left = copyTree(root.right.left);
					// reusing - point new root.right to the original right subtree
					cRoot.right = root.right.right;
					// curr is the cutoff node whose right child will be replaced by the new n
					TreeNode curr = getValNode(cRoot, node.val);
					// place n as curr's right child, make curr's original right child as the left
					// child of n.
					TreeNode tmp = curr.left;
					curr.left = new TreeNode(n);
					curr.left.right = tmp;

					next.add(cRoot);
					node = node.left;
				}
			}
			res = next;
		}
		return res;
	}

	private TreeNode getValNode(TreeNode n, int val) { // find the cutoff node in the new tree
		while (n != null) {
			if (n.val == val)
				break;
			n = n.left;
		}
		return n;
	}

	private TreeNode copyTree(TreeNode root) { // clone the right subtree
		if (root == null)
			return null;
		TreeNode cRoot = new TreeNode(root.val);
		cRoot.left = copyTree(root.left);
		cRoot.right = copyTree(root.right);
		return cRoot;
	}

	// Approach2
	public List<TreeNode> generateTreesApproach2(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		if (start > end) {
			trees.add(null);
			return trees;
		}

		for (int rootValue = start; rootValue <= end; rootValue++) {
			List<TreeNode> leftSubTrees = generateTrees(start, rootValue - 1);
			List<TreeNode> rightSubTrees = generateTrees(rootValue + 1, end);

			for (TreeNode leftSubTree : leftSubTrees) {
				for (TreeNode rightSubTree : rightSubTrees) {
					TreeNode root = new TreeNode(rootValue);
					root.left = leftSubTree;
					root.right = rightSubTree;
					trees.add(root);
				}
			}
		}
		return trees;
	}

	public static void main(String[] args) {
		M_0095_UniqueBinarySearchTrees2 obj = new M_0095_UniqueBinarySearchTrees2();
		List<TreeNode> res = obj.generateTrees(4);

		for (TreeNode node : res) {
			TreeNode.print(node);
			System.out.println();
		}
	}
}
