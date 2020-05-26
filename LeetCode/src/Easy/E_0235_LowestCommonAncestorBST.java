package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class E_0235_LowestCommonAncestorBST {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val < p.val && root.val < q.val) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        }else if(root.val > p.val && root.val > q.val) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        }
        // We have found the split point, i.e. the LCA node.
        return root;
    }
	
    public TreeNode lowestCommonAncestorAppraoch2(TreeNode root, TreeNode p, TreeNode q) {
        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode ptr = root;
        
        // Traverse the tree
        while (ptr != null) {

            // Value of ancestor/parent node.
            int parentVal = ptr.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
            	ptr = ptr.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
            	ptr = ptr.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return ptr;
            }
        }
        return null;
    }
	
	public static void main(String[] args) {
		E_0235_LowestCommonAncestorBST obj = new E_0235_LowestCommonAncestorBST();
		int[] inputArr = new int[]{6,2,8,0,4,7,9,3,5};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.lowestCommonAncestor(inputTree, new TreeNode(2), new TreeNode(4)).val);
	}
}
