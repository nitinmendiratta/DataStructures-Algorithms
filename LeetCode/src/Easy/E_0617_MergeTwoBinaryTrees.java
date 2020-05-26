package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class E_0617_MergeTwoBinaryTrees {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return null;
		if(t1 != null && t2 == null) return t1;
		if(t1 == null && t2 != null) return t2;
		if(t1.left == null && t1.right == null && t2.left == null && t2.right == null){
			t1.val = t1.val + t2.val;
			return t1;
		}
		t1.val = t1.val + t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

	public TreeNode mergeTreesIterative(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		Stack < TreeNode[] > stack = new Stack < > ();
		stack.push(new TreeNode[] {t1, t2});
		while (!stack.isEmpty()) {
			TreeNode[] t = stack.pop();
			if (t[0] == null || t[1] == null) {
				continue;
			}
			t[0].val += t[1].val;
			if (t[0].left == null) {
				t[0].left = t[1].left;
			} else {
				stack.push(new TreeNode[] {t[0].left, t[1].left});
			}
			if (t[0].right == null) {
				t[0].right = t[1].right;
			} else {
				stack.push(new TreeNode[] {t[0].right, t[1].right});
			}
		}
		return t1;
	}
	public static void main(String[] args) {
		E_0617_MergeTwoBinaryTrees obj = new E_0617_MergeTwoBinaryTrees();
		int[] inputArr = new int[]{1,2,3, -1,4};
		int[] inputArr2 = new int[]{2,3,4, 5,4};
		TreeNode inputTree = TreeNode.constructCompleteBinaryTree(inputArr);
		TreeNode inputTree2 = TreeNode.constructCompleteBinaryTree(inputArr2);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		TreeNode.print(inputTree2);
		System.out.println();
		System.out.println("OUTPUT");
		TreeNode.print(obj.mergeTrees(inputTree, inputTree2));
	}
}
