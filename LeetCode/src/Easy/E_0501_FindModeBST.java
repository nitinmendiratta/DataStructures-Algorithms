package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class E_0501_FindModeBST {

	
    // no extra space
	private int currVal;
	private int currCount = 0;
	private int maxCount = 0;
	private int modeCount = 0;
	private int[] modes;
	
	public int[] findMode(TreeNode root) {
		inorder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;
		inorder(root);
		return modes;
	}

	private void handleValue(int val) {
		if (val != currVal) {
			currVal = val;
			currCount = 0;
		}
		currCount++;
		if (currCount > maxCount) {
			maxCount = currCount;
			modeCount = 1;
		} else if (currCount == maxCount) {
			if (modes != null)
				modes[modeCount] = currVal;
			modeCount++;
		}
	}

	private void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		handleValue(root.val);
		inorder(root.right);
	}
	
	int maxFreq = 0;
    public int[] findModeApproach2(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        inorder(root, hm);
        
        for(Map.Entry entry: hm.entrySet()){
            if(maxFreq == (Integer)entry.getValue()){
                res.add((Integer)entry.getKey());
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    
    public void inorder(TreeNode root, HashMap<Integer, Integer> hm){
        if(root == null) return;
        inorder(root.left, hm);
        int currFreq = hm.getOrDefault(root.val, 0) + 1;
        hm.put(root.val, currFreq);

        if(currFreq > maxFreq){
            maxFreq = currFreq;
        }
        
        inorder(root.right, hm);
    }
	
	
	// using list
	Integer prev = null;
    int currFreq = 0;
	public int[] findModeApproach3(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
    
    public void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        
        if(prev != null && root.val == prev){
            currFreq++;
        }else{
            currFreq = 1;
        }
        prev = root.val;
        if(currFreq > maxFreq){
            maxFreq = currFreq;
            res.clear();
            res.add(root.val);
        }else if(currFreq == maxFreq){
            res.add(root.val);
        }
        
        inorder(root.right, res);
    }

	public static void main(String[] args) {
		E_0501_FindModeBST obj = new E_0501_FindModeBST();
		int[] inputArr = new int[]{6,2,2,2,3,3};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(Arrays.toString(obj.findMode(inputTree)));
		System.out.println(Arrays.toString(obj.findModeApproach3(inputTree)));
	}
}
