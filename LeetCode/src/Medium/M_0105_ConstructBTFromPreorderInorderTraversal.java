package Medium;
import java.util.*;
import Helper.TreeNode;
/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class M_0105_ConstructBTFromPreorderInorderTraversal {

	/*
	 * https://www.youtube.com/watch?v=PoBGyrIWisE&feature=emb_logo 
	 * Consider this input:
	 * 
	 * preorder: [1, 2, 4, 5, 3, 6] 
	 * inorder: [4, 2, 5, 1, 6, 3] 
	 * The obvious way to build the tree is:
	 * 
	 * 1. Use the first element of preorder, the 1, as root. 
	 * 2. Search it in inorder.
	 * 3. Split inorder by it, here into [4, 2, 5] and [6, 3]. 
	 * 4. Split the rest of preorder into two parts as large as the inorder parts, here into [2, 4, 5] and [3, 6]. 
	 * 5. Use preorder = [2, 4, 5] and inorder = [4, 2, 5] to add the left subtree. 
	 * 6. Use preorder =[3, 6]andinorder = [6, 3] to add the right subtree.
	 * 7. find root in preorder and left and right subtrees in in-order
	 */
	
	// Approach1: Recursive: Improvement using map
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
	    
	    for(int i = 0; i < inorder.length; i++) {
	        inMap.put(inorder[i], i);
	    }

	    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	    return root;
	}

	public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
	    if(preStart > preEnd || inStart > inEnd) return null;
	    
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inRoot = inMap.get(root.val);
	    int numsLeft = inRoot - inStart;
	    
	    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
	    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
	    
	    return root;
	}
	
	// Approach2: Brute Force Recursive
	public TreeNode buildTreeApproach2(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0; // Index of current root in inorder
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}
		int numsLeft = inIndex - inStart;
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + numsLeft + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}

	// Approach3: Difficult to understand, but most optimized
	// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34543/Simple-O(n)-without-map
	private int in = 0;
	private int pre = 0;

	public TreeNode buildTreeApproach3(int[] preorder, int[] inorder) {
		return build(preorder, inorder, Integer.MIN_VALUE);
	}

	private TreeNode build(int[] preorder, int[] inorder, int stop) {
		if (pre >= preorder.length)
			return null;
		if (inorder[in] == stop) {
			in++;
			return null;
		}
		TreeNode node = new TreeNode(preorder[pre++]);
		node.left = build(preorder, inorder, node.val);
		node.right = build(preorder, inorder, stop);
		return node;
	}
    
	// Cant Understand
	// Approach 4: Iterative
	public TreeNode buildTreeApproach4(int[] preorder, int[] inorder) {
		if (inorder == null || inorder.length == 0)
			return null;
		int j = 0;
		TreeNode root = new TreeNode(preorder[0]);
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		TreeNode node = null;
		
		for (int i = 1; i < preorder.length; i++) {
			TreeNode cur = new TreeNode(preorder[i]);
			while (stack.size() > 0 && stack.peek().val == inorder[j]) {
				node = stack.pop();
				j++;
			}
			if (node != null) {
				node.right = cur;
				node = null;
			} else {
				stack.peek().left = cur;
			}
			stack.push(cur);
		}
		return root;
	}
	
	public static void main(String[] args) {
		M_0105_ConstructBTFromPreorderInorderTraversal obj = new M_0105_ConstructBTFromPreorderInorderTraversal();
		TreeNode res = obj.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
		res.print(res);
	}
}
