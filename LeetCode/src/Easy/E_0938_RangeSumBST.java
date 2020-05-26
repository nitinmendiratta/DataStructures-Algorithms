package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class E_0938_RangeSumBST {

	int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }
	
    // iterative
    public int rangeSumBSTIterative(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R)
                    ans += node.val;
                if (L < node.val)
                    stack.push(node.left);
                if (node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }
    
    
    // higher complexity approach
	int res = 0;
    public int rangeSumBSTApproach2(TreeNode root, int L, int R) {
        if(root == null) return 0;
        rangeSumBSTApproach2(root.left, L, R);
        if(root.val >= L && root.val <= R){
            res += root.val;
        }
        rangeSumBSTApproach2(root.right, L, R);
        return res;
    }
    
	public static void main(String[] args) {
		E_0938_RangeSumBST obj = new E_0938_RangeSumBST();
		TreeNode inputTree = TreeNode.stringToTreeNode("10,10,null,10,10,null,10,null,null,null,null");
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.rangeSumBST(inputTree, 0, 100));
	}
}
