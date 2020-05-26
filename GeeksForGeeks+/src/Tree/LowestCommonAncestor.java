package Tree;
import java.util.ArrayList;
/*
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */
public class LowestCommonAncestor {

	public static int lcsBT(TreeNode root, int a, int b){
		if(root == null) return Integer.MAX_VALUE;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> listb = new ArrayList<Integer>();
		rootToNodePath(root,a,lista);
		rootToNodePath(root,b,listb);
		int i;
		for(i = 0;i < Math.min(lista.size(),listb.size());i++)
			if(lista.get(i) != listb.get(i)) break;
		return lista.get(i-1);
	}
	
	public static boolean rootToNodePath(TreeNode root, int x, ArrayList<Integer> list){
		
		if(root == null) return false;
		if(root.data == x){
			list.add(0,root.data);
			return true;
		}
		if(rootToNodePath(root.left,x,list) || rootToNodePath(root.right,x,list)){
			list.add(0,root.data);
			return true;
		}
		return false;
	}
	
	public static int lcsBST(TreeNode root, int a, int b){
		if(root == null) return Integer.MAX_VALUE;
		
		if(root.data < a && root.data < b){
			return lcsBST(root.right,a,b);
		}
		
		if(root.data > a && root.data > b){
			return lcsBST(root.left,a,b);
		}
		return root.data;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		//System.out.println("LowestCommonAncestor is:"+lcsBT(root,2,4));
		
		TreeNode root2 = new TreeNode(20);
		root2.left = new TreeNode(8);
		root2.right = new TreeNode(22);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(12);
		root2.right.left = new TreeNode(21);
		root2.right.right = new TreeNode(23);
		System.out.println("LowestCommonAncestor is:"+lcsBST(root2,12,8));
	}
}
