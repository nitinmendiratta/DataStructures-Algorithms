package Array_Matrix;
import java.util.*;

/*
 * http://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
 * http://buttercola.blogspot.com/2016/01/leetcode-count-of-smaller-numbers-after.html
 * Every node will maintain a val sum recording the total of number on it's left bottom side, dupcounts the duplication. 
 * For example, [3, 2, 2, 6, 1], from back to beginning,we would have:
                1(0, 1)
                     \
                     6(3, 1)
                     /
                   2(0, 2)
                       \
                        3(0, 1)
When we try to insert a number, the total number of smaller number would be adding dup and sum of the nodes where we turn right. 
for example, if we insert 5, it should be inserted on the way down to the right of 3, the nodes where we turn right is 1(0,1), 2,(0,2), 3(0,1), 
so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4
if we insert 7, the right-turning nodes are 1(0,1), 6(3,1), so answer should be (0 + 1) + (3 + 1) = 5
 */

class BSTNode {
    int val;
    int dup = 1;
    int numOfLeftNodes;
    BSTNode left, right;
     
    BSTNode(int val, int numOfLeftNodes) {
        this.val = val;
        this.numOfLeftNodes = numOfLeftNodes;
    }
}

public class A050_CountSmallerElementsOnRightSide {

	    public List<Integer> countSmaller(int[] nums) {
	        Integer[] result = new Integer[nums.length];
	         
	        BSTNode root = null;
	        for (int i = nums.length - 1; i >= 0; i--) {
	            root = insert(root, nums[i], i, result, 0);
	        }
	         
	        return Arrays.asList(result);
	    }
	     
	    private BSTNode insert(BSTNode root, int num, int i, Integer[] result, 
	                           int preSum) {
	        if (root == null) {
	            root = new BSTNode(num, 0);
	            result[i] = preSum;
	            return root;
	        } else if (root.val == num) {
	            root.dup++;
	            result[i] = preSum + root.numOfLeftNodes;
	            return root;
	        } else if (root.val > num) {
	            root.numOfLeftNodes++;
	            root.left = insert(root.left, num, i, result, preSum);
	        } else {
	            root.right = insert(root.right, num, i, result, 
	                preSum + root.numOfLeftNodes + root.dup);
	        }
	         
	        return root;
	    }
	     
	    
	public static void main(String[] args) {
		A050_CountSmallerElementsOnRightSide obj = new A050_CountSmallerElementsOnRightSide();
		int[] arr = {1, 2, 3, 4, 5};
		List<Integer> res = obj.countSmaller(arr);
		System.out.print(res);
	}
}
