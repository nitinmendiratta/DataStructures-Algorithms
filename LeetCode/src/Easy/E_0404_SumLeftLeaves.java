package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class E_0404_SumLeftLeaves {

	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;
        int sum = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) sum += root.left.val;
            else sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
	public int sumOfLeftLeavesIterative(TreeNode root) {
	    if(root == null) return 0;
	    int ans = 0;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    
	    while(!stack.empty()) {
	        TreeNode node = stack.pop();
	        if(node.left != null) {
	            if (node.left.left == null && node.left.right == null)
	                ans += node.left.val;
	            else
	                stack.push(node.left);
	        }
	        if(node.right != null) {
	            if (node.right.left != null || node.right.right != null)
	                stack.push(node.right);
	        }
	    }
	    return ans;
	}
	public static void main(String[] args) {
		E_0404_SumLeftLeaves obj = new E_0404_SumLeftLeaves();
		int[] inputArr = new int[]{6,2,8,0,4,7,9,3,5};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.sumOfLeftLeaves(inputTree));
		System.out.println(obj.sumOfLeftLeavesIterative(inputTree));
	}
}
