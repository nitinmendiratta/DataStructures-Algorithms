package Medium;
import java.util.HashMap;
import Helper.TreeNode;
/*
 * https://leetcode.com/problems/house-robber-iii/
 */
public class M_0337_HouseRobber3 {

	// DP: https://www.youtube.com/watch?v=bEZxjZCY618
	// res[0] -> denotes the maximum amount of money that can be robbed if root is not robbed
	// res[1] -> signifies the maximum amount of money robbed if root is robbed.
	public int rob(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    // root not robbed, so we have both option can rob or not rob left and right
	    // so max of left robbed vs not robbed + max of right robbed vs not robbed
	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); 
	    
	    // root robbed, so have to take left not robbed, right not robbed
	    res[1] = root.val + left[0] + right[0]; 
	    
	    return res;
	}
	
	// using DFS and backtracking; bottom to top
    // at certain point/node, this is how we determine the max
    // There are a couple of cases at this node 
    // 1. if we consider to rob this node: max is current root.val + the value get from 
    // robbing both its grandchildren 
    // 2. if we consider not to rob: max is the sum of both its left child sum and its right 
    // sum if exists 
    // finally, we take the max and return and of course store the result into hashmap for 
    // future use
	
	public int robApproach2(TreeNode root) {
        return DFS(root, new HashMap<TreeNode, Integer>());
    }

    public int DFS(TreeNode root, HashMap<TreeNode, Integer>map){
        if(root == null) return 0;
        
        // if this root has been visited and the max has been calculated, return immediately
        if(map.containsKey(root)) return map.get(root);
        
        int result = 0;
        // say we rob the current root, we will also rob its both grandchildren
        // below is to rob its left child's both children
        if(root.left != null)
            result += DFS(root.left.left, map) + DFS(root.left.right, map); 
        // below is to rob its right child's both children
        if(root.right != null)
            result += DFS(root.right.left, map) + DFS(root.right.right, map);
        
        // the sum we get from result will be compared to just robbing its left and right child 
        result = Math.max(result + root.val, DFS(root.left, map)+DFS(root.right, map));
        map.put(root, result);
        return result;
    
    }
    
    
    // brute force
    public int robApproach3(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robInclude(root), robExclude(root));
    }

    public int robInclude(TreeNode node) {
        if(node == null) return 0;
        return robExclude(node.left) + robExclude(node.right) + node.val;
    }

    public int robExclude(TreeNode node) {
        if(node == null) return 0;
        return robApproach3(node.left) + robApproach3(node.right);
    }
    
	public static void main(String[] args) {
		M_0337_HouseRobber3 obj = new M_0337_HouseRobber3();
		TreeNode root = TreeNode.createRandomBST(5);
		System.out.println(obj.rob(root));
	}
}
