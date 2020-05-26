package Tree;
/*
 * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 * Time Complexity: O(n) where n is number of nodes in the given binary tree.
 */
public class BT_034_PrintNodesAtkDistanceFromRoot {

	// Approach 1
	public static void printKDistantce(TreeNode root , int k){
		if(root == null) 
			return;
		if(k == 0){
			System.out.print(root.data+",");
			return;
		}
		else{      
			printKDistantce(root.left, k-1 ) ;
			printKDistantce(root.right, k-1 ) ;
		}
	}
	// Approach 2 : Prints actual path from root to distance x
	public static void printNodes(TreeNode root, int x){
		if(root == null) return;
		int[] paths = new int[100];
		actualPath(root,paths,0,x);
	}

	public static void actualPath(TreeNode root, int[] paths, int pathLen, int x){
		
		if(root == null) return;
		
		paths[pathLen] = root.data;
		pathLen++;

		if((pathLen-1) == x){
			print(paths,pathLen);
		}else{
			actualPath(root.left,paths,pathLen,x);
			actualPath(root.right,paths,pathLen,x);
		}
	}

	public static void print(int[] paths, int pathLen){
		for(int i = 0;i < pathLen;i++){
			System.out.print(paths[i]+",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		printKDistantce(root,2);
		System.out.println();
		System.out.println("Actual Paths");
		printNodes(root,2);
		
	}

}
