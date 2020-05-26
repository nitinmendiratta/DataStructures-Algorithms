package Easy;
import java.util.*;

import Helper.NaryTreeNode;
/*
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class E_0589_NaryTreePreorderTraversal {

	List<Integer> res = new ArrayList<Integer>();
	public List<Integer> preorderRecursive(NaryTreeNode root) {
		
        if(root == null) return res;
        res.add(root.val);
        for(NaryTreeNode n: root.children){
        	preorderRecursive(n);
        }
        return res;
    }
    
    public List<Integer> preorderIterative(NaryTreeNode root) {
        if(root == null) return res;
        Stack<NaryTreeNode> stck = new Stack<NaryTreeNode>();
        stck.push(root);
        while(!stck.isEmpty()){
        	NaryTreeNode curr = stck.pop();
            int size = curr.children.size();
            for(int i = size-1; i >= 0; i--){
                stck.push(curr.children.get(i));
            }
            res.add(curr.val);
        }
        return res;
    }
}
