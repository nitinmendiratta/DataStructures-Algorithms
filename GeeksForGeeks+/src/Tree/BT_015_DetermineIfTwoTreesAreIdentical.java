package Tree;

/*
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 * https://leetcode.com/problems/same-tree/
 * Duplicate E_100
 */
public class BT_015_DetermineIfTwoTreesAreIdentical {
	public boolean isIdentical(TreeNode p, TreeNode q) {
		if(q == null && p == null) return true;
		if(p != null && q != null){
			return (p.data == q.data) && isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
		}
		return false;
	}
}
