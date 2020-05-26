package Tree;
/*
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 */
public class BT_020_PrintAllPathsFromRootToLeaf {

	public void printPath(TreeNode root){
		int path[] = new int[100];
		actualPrint(root,path,0);
	}
	
	// arrays are not passed by reference we have different array for each path and we print that recursively
	public void actualPrint(TreeNode root, int[] paths, int pathLen){
		
		if(root == null) return;
		
		paths[pathLen] = root.data;
		pathLen++;
		
		if(root.left == null && root.right == null){
			printArray(paths,pathLen);
		}
		else{
			actualPrint(root.left,paths,pathLen);
			actualPrint(root.right,paths,pathLen);
		}
	}
	
	public void printArray(int[] path, int n){
		for(int i = 0;i < n;i++){
			System.out.print(path[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BT_020_PrintAllPathsFromRootToLeaf obj = new BT_020_PrintAllPathsFromRootToLeaf();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		obj.printPath(root);
	}

}
