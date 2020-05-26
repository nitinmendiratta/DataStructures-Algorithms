package Tree;
/*
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 */
public class BT_029_ConstructTreeGivenInorderAndPreorderTraversals {
	static int pIndx = 0;
	
	public static TreeNode buildTree(String inorder, String preorder, int startIndx,int endIndx){
		if(startIndx > endIndx) return null;
 
		TreeNode root = new TreeNode(preorder.charAt(pIndx++));
		
		if(startIndx == endIndx) return root;
		int inIndx = search(inorder, startIndx, endIndx, root.data);
		
		root.left = buildTree(inorder, preorder, startIndx, inIndx-1);
		root.right = buildTree(inorder, preorder, inIndx+1, endIndx);
		return root;
	}
	
	public static int search(String inorder, int s, int e, int find){
		int i;
		for(i = s;i <= e;i++){
			if(find == inorder.charAt(i)) break;
		}
		return i;
	}
	
	public static void main(String[] args) {
		TreeNode root = buildTree("DBEAFC","ABDECF",0,"DBEAFC".length()-1);
		TreeTraversal.inOrderTraversal(root);
	}
}
