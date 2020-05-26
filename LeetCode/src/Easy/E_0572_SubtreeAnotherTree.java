package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class E_0572_SubtreeAnotherTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
		if(t == null || s == null) return false;
        return isSubtree(s.left, t) || isIdentical(s, t) || isSubtree(s.right, t);
    }
     public boolean isIdentical(TreeNode p, TreeNode q) {
        if(q == null && p == null) return true;
		if(p != null && q != null){
			return (p.val == q.val) && isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
		}
		return false;
    }
	public static void main(String[] args) {
		E_0572_SubtreeAnotherTree obj = new E_0572_SubtreeAnotherTree();
		int[] inputArr = new int[]{6,2,2,2,3,3,3};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.isSubtree(inputTree, inputTree.left));
	}
}
