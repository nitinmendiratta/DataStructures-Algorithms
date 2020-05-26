package Tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SerializeAndDeserializeBT {

	public static void serialize(TreeNode root, FileOutputStream out) throws IOException{		
		if(root == null){
			//write marker
			out.write(0);
		}
		else{
			//write data
			out.write(root.data);
			serialize(root.left, out);
			serialize(root.right, out);
		}
	}
	
	public static TreeNode deserialize(TreeNode root, FileInputStream in) throws IOException{
		int c = in.read();
		if(c == 0 || c == -1) return null;
		root = new TreeNode(c);
		root.left = deserialize(root.left,in);
		root.right = deserialize(root.right,in);
		return root;
	}
	
	public static void main(String[] args) throws IOException {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		FileInputStream in = new FileInputStream("/home/nitin/Desktop/DataStructures/GeeksForGeeks/src/Tree/input.txt");
		FileOutputStream out = new FileOutputStream("/home/nitin/Desktop/DataStructures/GeeksForGeeks/src/Tree/input.txt");
		
		//System.out.println("serialize");
		serialize(root, out);
		/*int c;
		while ((c = in.read()) != -1) {
            System.out.print(c);
         }*/
		TreeNode root2 = null;		
		//System.out.println("deserialize");
		root2 = deserialize(root2, in);
		//root2.print(root2);
		BT_015_DetermineIfTwoTreesAreIdentical obj = new BT_015_DetermineIfTwoTreesAreIdentical();
		System.out.println("identical:"+obj.isIdentical(root,root2));
	}
}
