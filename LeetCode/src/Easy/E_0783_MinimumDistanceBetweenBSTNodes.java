package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class E_0783_MinimumDistanceBetweenBSTNodes {

	int min = Integer.MAX_VALUE;
	TreeNode prev = null;
	
	public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        minDiffInBST(root.left);
        if(prev != null){
            System.out.println(prev.val+ " : " +root.val);
            min = Math.min(min, Math.abs(prev.val - root.val));
        }
        prev = root;
        minDiffInBST(root.right);
        return min;
    }

	public static void main(String[] args) {
		E_0783_MinimumDistanceBetweenBSTNodes obj = new E_0783_MinimumDistanceBetweenBSTNodes();
		TreeNode inputTree = TreeNode.stringToTreeNode("90,69,null,49,89,null,52,null,null,null,null");
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.minDiffInBST(inputTree));
	}
}
