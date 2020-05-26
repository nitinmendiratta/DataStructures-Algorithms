package Medium;
import java.util.*;
import Helper.*;

/*
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class M_0129_SumRootLeafNumbers {

	// Recursive
	public int sumNumbers(TreeNode root) {

		return sumNumbersHelper(root, 0);
	}

	public int sumNumbersHelper(TreeNode root, int currSum) {
		
		if (root == null) {
	        return 0;
	    }
		currSum = currSum * 10 + root.val;

		if (root.left == null && root.right == null) {
			return currSum;
		}

		return sumNumbersHelper(root.left, currSum) + sumNumbersHelper(root.right, currSum);
	}

	// Iterative: Create special node
	class NodeSum {
		TreeNode node;
		int sum;

		public NodeSum(TreeNode node, int sum) {
			this.node = node;
			this.sum = sum;
		}
	}

	public int sumNumbersApproach2(TreeNode root) {
		if (root == null)
			return 0;
		int res = 0;
		Queue<NodeSum> queue = new LinkedList<>();
		queue.add(new NodeSum(root, root.val));

		while (!queue.isEmpty()) {
			NodeSum poll = queue.poll();
			TreeNode node = poll.node;

			int sum = poll.sum;
			if (node.left != null) {
				NodeSum newNode = new NodeSum(node.left, sum * 10 + node.left.val);
				queue.add(newNode);
			}

			if (node.right != null) {
				NodeSum newNode = new NodeSum(node.right, sum * 10 + node.right.val);
				queue.add(newNode);
			}

			if (node.left == null && node.right == null)
				res += sum;
		}
		return res;
	}

	// Iterative: modify original nodes
	public int sumNumbersApproach3(TreeNode root) {
		if (root == null)
			return 0;

		TreeNode curr = root;
		// Create an empty stack and push root to it
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int totlalSum = 0;

		while (!stack.empty()) {
			curr = stack.pop();

			if (curr.right != null) {
				curr.right.val = curr.val * 10 + curr.right.val;
				stack.push(curr.right);
			}

			if (curr.left != null) {
				curr.left.val = curr.val * 10 + curr.left.val;
				stack.push(curr.left);
			}

			if (curr.left == null && curr.right == null) { // leaf node
				totlalSum += curr.val;
			}
		}
		return totlalSum;
	}

	public static void main(String[] args) {
		M_0129_SumRootLeafNumbers obj = new M_0129_SumRootLeafNumbers();
		TreeNode root = TreeNode.createRandomBST(4);
		System.out.println();
		TreeNode.printNode(root);
		System.out.println(obj.sumNumbers(root));
		System.out.println(obj.sumNumbersApproach2(root));
		System.out.println(obj.sumNumbersApproach3(root));
	}
}
