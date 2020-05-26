package Easy;
import java.util.*;

import Helper.NaryTreeNode;
/*
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class E_0590_NaryTreePostorderTraversal {

	List<Integer> res = new ArrayList<Integer>();
    
    public List<Integer> postorder(NaryTreeNode root) {
        if(root == null) return res;
        for(NaryTreeNode n: root.children){
            postorder(n);
        }
        res.add(root.val);
        return res;
    }
    
    // calculate inorder and reverse
    public List<Integer> postorderIterative(NaryTreeNode root) {
    	if(root == null) return res;
        Stack<NaryTreeNode> stck = new Stack<NaryTreeNode>();
        stck.push(root);
        while(!stck.isEmpty()){
        	NaryTreeNode curr = stck.pop();
            res.add(curr.val);
            for(NaryTreeNode node: curr.children){
                stck.add(node);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
