package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class E_0671_SecondMinimumNodeBT {

	int min1;
    long ans = Long.MAX_VALUE;
	/*
	 * Let min1 = root.val. When traversing the tree at some node, node, if node.val > min1, we know all values in the subtree at node are at least node.val, 
	 * so there cannot be a better candidate for the second minimum in this subtree.
	 * Thus, we do not need to search this subtree.
	 * 
	 * Also, as we only care about the second minimum ans, we do not need to record any values that are larger than our current candidate for the second minimum, 
    */
    public void dfs(TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min1 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
    
	public static void main(String[] args) {
		E_0671_SecondMinimumNodeBT obj = new E_0671_SecondMinimumNodeBT();
		int[] inputArr = new int[]{1,2,3,-1,4};
		TreeNode inputTree = TreeNode.constructCompleteBinaryTree(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.findSecondMinimumValue(inputTree));
	}
}
