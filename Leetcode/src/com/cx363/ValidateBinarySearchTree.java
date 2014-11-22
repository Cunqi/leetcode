package com.cx363;

import java.util.ArrayList;
import java.util.List;

import com.cx363.entity.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	
    	if(null != root) {
    		List<Integer> list = new ArrayList<Integer>();
    		travelTree(root, list);
    		
    		for(int i=0; i<list.size()-1; i++) {
    			if(list.get(i) >= list.get(i+1)){
    				return false;
    			}
    		}
    	}
        
    	return true;
    }
    
    private void travelTree(TreeNode node, List<Integer> result) {
    	
    	TreeNode left  = node.left;
    	TreeNode right = node.right;
    	
    	//travel left
    	if(null != left) travelTree(left, result);
    	
    	//record
    	result.add(node.val);
    	
    	//travel right
    	if(null != right) travelTree(right, result);
    }
}
