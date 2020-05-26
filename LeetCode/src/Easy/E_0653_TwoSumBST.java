package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class E_0653_TwoSumBST {

	public boolean findTarget(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
	public static void main(String[] args) {
		E_0653_TwoSumBST obj = new E_0653_TwoSumBST();
		int[] inputArr = new int[]{1,2,3, 1,4};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.findTarget(inputTree, 2));
	}
}
