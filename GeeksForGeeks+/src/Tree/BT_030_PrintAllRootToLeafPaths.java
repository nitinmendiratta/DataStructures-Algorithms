package Tree;
/*
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
 * Time Complexity: O(n2) where n is number of nodes.
 */
public class BT_030_PrintAllRootToLeafPaths {

	public void printAllPaths(TreeNode root){
		if(root == null) return;
		int[] pathArr = new int[100];
		actualPathSearch(root,pathArr,0);
	}

	public void actualPathSearch(TreeNode root, int[] paths, int pathLen){
		if(root == null) return;
		paths[pathLen] = root.data;
		pathLen++;
		// u reached the leaf node
		if(root.left == null && root.right == null){
			printArray(paths, pathLen);
		}
		else{
			actualPathSearch(root.left,paths,pathLen);
			actualPathSearch(root.right,paths,pathLen);
		}
	}
	  /* Utility function that prints out an array on a line. */
	public void printArray(int paths[], int pathLen){
		for(int i = 0;i < pathLen;i++){
			System.out.print(paths[i]+",");
		}
		System.out.println();
    }
	public static void main(String[] args) {
		BT_030_PrintAllRootToLeafPaths obj = new BT_030_PrintAllRootToLeafPaths();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		obj.printAllPaths(root);
	}
}
