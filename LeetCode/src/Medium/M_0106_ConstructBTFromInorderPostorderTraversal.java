package Medium;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class M_0106_ConstructBTFromInorderPostorderTraversal {

	// Approach1: Recursive: Improvement using map
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
	    
	    for(int i = 0; i < inorder.length; i++) {
	        inMap.put(inorder[i], i);
	    }

	    TreeNode root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	    return root;
	}

	public TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	    if(postStart < 0 || inStart > inEnd) return null;
	    
	    TreeNode root = new TreeNode(postorder[postEnd]);
	    int inRoot = inMap.get(root.val);
	    int numsLeft = inRoot - inStart;
	    
	    root.left = buildTree(postorder, postStart, postStart + numsLeft -1, inorder, inStart, inRoot - 1, inMap);
	    root.right = buildTree(postorder, postStart + numsLeft, postEnd-1, inorder, inRoot + 1, inEnd, inMap);
	    
	    return root;
	}

	// Cant Understand
	// Approach2: Without Hashmap
	int pInorder;   // index of inorder array
	int pPostorder; // index of postorder array

	public TreeNode buildTreeApproach2(int[] inorder, int[] postorder) {
		pInorder = inorder.length - 1;
		pPostorder = postorder.length - 1;
		
		return buildTreeHelper(inorder, postorder, null);
	}
	
	private TreeNode buildTreeHelper(int[] inorder, int[] postorder, TreeNode end) {
		if (pPostorder < 0) {
			return null;
		}
		
		// create root node
		TreeNode n = new TreeNode(postorder[pPostorder--]);
		
		// if right node exist, create right subtree
		if (inorder[pInorder] != n.val) {
			n.right = buildTreeHelper(inorder, postorder, n);
		}
		
		pInorder--;
		
		// if left node exist, create left subtree
		if ((end == null) || (inorder[pInorder] != end.val)) {
			n.left = buildTreeHelper(inorder, postorder, end);
		}
		
		return n;
	}
	
	// Cant Understand
	// Approach3: Iterative
	// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34807/Java-iterative-solution-with-explanation
	public TreeNode buildTreeApproach3(int[] inorder, int[] postorder) {
	    if (inorder.length == 0 || postorder.length == 0) return null;
	    int ip = inorder.length - 1;
	    int pp = postorder.length - 1;
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null;
	    TreeNode root = new TreeNode(postorder[pp]);
	    stack.push(root);
	    pp--;
	    
	    while (pp >= 0) {
	        while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
	            prev = stack.pop();
	            ip--;
	        }
	        TreeNode newNode = new TreeNode(postorder[pp]);
	        if (prev != null) {
	            prev.left = newNode;
	        } else if (!stack.isEmpty()) {
	            TreeNode currTop = stack.peek();
	            currTop.right = newNode;
	        }
	        stack.push(newNode);
	        prev = null;
	        pp--;
	    }
	    
	    return root;
	}
	
	public static void main(String[] args) {
		M_0106_ConstructBTFromInorderPostorderTraversal obj = new M_0106_ConstructBTFromInorderPostorderTraversal();
		TreeNode res = obj.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
		res.print(res);
	}
}
