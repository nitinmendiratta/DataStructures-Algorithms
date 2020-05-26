package Tree;

/*
 * http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 
 * Time Complexity: O(n)
 */
public class BT_028_RootToLeafPathSumEqualToGivenNumber {

	public void hasPath(TreeNode root, int x){
		if(root == null) return;
		int[] pathArr = new int[100];
		actualPathSearch(root,pathArr,x,0);
	}

	public void actualPathSearch(TreeNode root, int[] paths, int s, int pathLen){
		if(root == null) return;
		paths[pathLen] = root.data;
		pathLen++;
		// u reached the leaf node
		if(root.left == null && root.right == null){
			if(check(paths,pathLen,s)) return;
		}
		else{
			actualPathSearch(root.left,paths,s,pathLen);
			actualPathSearch(root.right,paths,s,pathLen);
		}
	}

	public boolean check(int[] paths,int pathLen,int s){
		int sum = 0;
		for(int i = 0;i < pathLen;i++){
			sum += paths[i];
		}
		if(s == sum){
			System.out.println("Found path:");
			for(int i = 0;i < pathLen;i++){
				System.out.print(paths[i]+",");
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		BT_028_RootToLeafPathSumEqualToGivenNumber obj = new BT_028_RootToLeafPathSumEqualToGivenNumber();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		obj.hasPath(root,8);
	}
}
