package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class E_0108_ConvertSortedArrayToBST {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		int len = nums.length;
		return sortedArrayToBSTHelper(nums, 0, len -1);
	}

	public TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
		/* Base Case */
        if (start > end) { 
            return null; 
        } 
        if (start == end) return new TreeNode(nums[start]);
        /* Get the middle element and make it root */
        int mid = start + (end-start)/2; 
        TreeNode node = new TreeNode(nums[mid]); 
  
        /* Recursively construct the left subtree and make it left child of root */
        node.left = sortedArrayToBSTHelper(nums, start, mid - 1); 
  
        /* Recursively construct the right subtree and make it right child of root */
        node.right = sortedArrayToBSTHelper(nums, mid + 1, end); 
          
        return node; 
	}
	
	
	public static void main(String[] args) {


	}
}
