package Helper;
import java.util.*;

public class NaryTreeNode {
	public int val;
    public List<NaryTreeNode> children;

    public NaryTreeNode() {}

    public NaryTreeNode(int _val, List<NaryTreeNode> _children) {
        val = _val;
        children = _children;
    }
//    public static NaryTreeNode constructBstHelper(NaryTreeNode root , List<NaryTreeNode> _children){ 
//		if(root == null) {  
//			root = new NaryTreeNode(data, ); 
//			return root; 
//		} 
//		if(data <= root.val) 
//			root.left = constructBstHelper(root.left, data); 
//		else
//			root.right = constructBstHelper(root.right, data); 
//		return root;      
//	} 
//
//	public static TreeNode constructBst(int arr[]) { 	
//		int n = arr.length;
//		if(n == 0) return null; 
//		TreeNode root = null; 
//
//		for(int i = 0; i < n; i++) 
//			root = constructBstHelper(root , arr[i]); 
//
//		return root; 
//	}
	public static void print(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + ",");
		print(root.left);
		print(root.right);
	}
}
