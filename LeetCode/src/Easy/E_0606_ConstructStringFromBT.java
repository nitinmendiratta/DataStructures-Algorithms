package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class E_0606_ConstructStringFromBT {

	public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";   
    }
    
    public String tree2strIterative(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        // visited is used to check if we reached a leaf
        Set < TreeNode > visited = new HashSet < > ();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            // if visited has it means it is a leaf and has no right left child so close the bracket
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
	public static void main(String[] args) {
		E_0606_ConstructStringFromBT obj = new E_0606_ConstructStringFromBT();
		int[] inputArr = new int[]{1,2,3, -1,4};
		TreeNode inputTree = TreeNode.constructCompleteBinaryTree(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.tree2str(inputTree));
	}
}
