package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/longest-univalue-path/
 * https://www.geeksforgeeks.org/longest-path-values-binary-tree/
 */
public class E_0687_LongestUnivaluePath {

	//Global max
	int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root, null);
        return max;
    }
    private int dfs(TreeNode cur, TreeNode parent) {
        if (cur == null) return 0;
        int left = dfs(cur.left, cur);
        int right = dfs(cur.right, cur);
        
        //update global variable
        // this max is basically path including curr node as the passing point
        max = Math.max(max, left + right);
            
        //caculate what to return
        int path = 0;
        // if parent is same as cur we return max of left and right instead of sum of both left and right othrwise it will be 1 more count
        if (parent != null && cur.val == parent.val) {
            path = 1 + Math.max(left, right);
        }
        return path;
    }
 
    
    // approach 2
	public int longestUnivaluePathApproach2(TreeNode root) {
		max = 0;
		longestPath(root);
		return max;
	}

	public int longestPath(TreeNode node) {
		// Base case: if null node, return 0
		if (node == null) {
			return 0;
		}

		// Get the max length from left and right
		int maxLeft = longestPath(node.left);
		int maxRight = longestPath(node.right);

		// Calculate the current max length
		int maxLeftSoFar = 0;
		int maxRightSoFar = 0;

		// Compare parent node with child node
		// If they are the same, extend the max length by one 
		if (node.left != null && node.left.val == node.val) {
			maxLeftSoFar = maxLeft + 1;
		}
		if(node.right != null && node.right.val == node.val) {
			maxRightSoFar = maxRight + 1;
		}

		// Update the max with the sum of left and right length
		max = Math.max(max, maxLeftSoFar + maxRightSoFar);

		// Return the max from left and right to upper node
		// since only one side path is valid
		return Math.max(maxLeftSoFar,maxRightSoFar);
	}
	public static void main(String[] args) {
		E_0687_LongestUnivaluePath obj = new E_0687_LongestUnivaluePath();
		/* Let us cona Binary Tree 
			     5 
			   /   \ 
			  4     5 
			 / \   / \ 
		    4   4 5   5 */
		TreeNode root = null; 
		root = new TreeNode(5); 
		root.left = new TreeNode(4); 
		root.right = new TreeNode(5); 
		root.left.left = new TreeNode(4); 
		root.left.right = new TreeNode(4); 
		root.right.right = new TreeNode(5); 
		root.right.left = new TreeNode(5);
		System.out.print(obj.longestUnivaluePath(root)); 
	}
}
