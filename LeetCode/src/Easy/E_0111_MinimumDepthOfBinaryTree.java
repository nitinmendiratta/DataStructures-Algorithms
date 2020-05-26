package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class E_0111_MinimumDepthOfBinaryTree {

	public int minDepth(TreeNode root) {

		if(root == null){
			return 0;
		}
		int lDepth = minDepth(root.left);
		int rDepth = minDepth(root.right);
		int min = Math.min(lDepth, rDepth);
		// min 0 if root has only 1 child
		return 1 + (min == 0 ? Math.max(lDepth, rDepth) : min);
	}

	public int minDepthApproach2(TreeNode root) {
		if(root == null){
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		int minDepth = 0;
		queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			minDepth++;
			for(int i = 0; i < size; i++){
				TreeNode node =  queue.poll();
				if(node.left == null && node.right == null){
					return minDepth;
				}
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
		}
		return minDepth;
	}

	public static void main(String[] args) {
		E_0111_MinimumDepthOfBinaryTree obj = new E_0111_MinimumDepthOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);*/
		System.out.println("Min Depth:"+obj.minDepth(root));
	}
}
