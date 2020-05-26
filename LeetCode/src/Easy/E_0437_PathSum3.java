package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/path-sum-iii/
 */
public class E_0437_PathSum3 {

	public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        HashMap <Integer, Integer> prevSum = new HashMap<>();  
        prevSum.put(0,1);
        return pathSumHelper(root, prevSum, 0, sum);
    }
    
    public int pathSumHelper(TreeNode root, HashMap <Integer, Integer> prevSum, int currsum, int target) {
        if(root == null) return 0;
        currsum += root.val;
         

        // currsum exceeds given sum by currsum - sum. Find number of subarrays having   
        // this sum and exclude those subarrays from currsum by increasing count by same amount. 
        int res = prevSum.getOrDefault(currsum - target, 0);
        
        // Add currsum value to count of different values of sum.  
        Integer count = prevSum.getOrDefault(currsum, 0); 
        prevSum.put(currsum, count + 1); 
       
        res += pathSumHelper(root.left, prevSum, currsum, target) + pathSumHelper(root.right, prevSum, currsum, target);
        // restore the map, as the recursion goes from the bottom to the top
        // if left subtree has been scanned, preSum has to remove this path, because this path is not the prefix path of the right subtree. Same as the left subtree, when right subtree is scanned, the path should be removed too.
        prevSum.put(currsum, prevSum.get(currsum) - 1);
        return res;
    }
	public static void main(String[] args) {
		E_0437_PathSum3 obj = new E_0437_PathSum3();
		int[] inputArr = new int[]{6,2,8,0,4,7,9,3,5};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.pathSum(inputTree, 8));
	}
}
