package com.cx363;

import com.cx363.entity.TreeNode;

public class MaximumDepthOfBinaryTree {
	private int max = 0;
    public int maxDepth(TreeNode root) {
        
    	if(null != root) {
    		traverse(root, 1);
    	}
    	
        return max;
    }
    
    private void traverse(TreeNode node, int level) {
    	if(node.left == null && node.right == null) {
    		max = Math.max(max, level);
    		return;
    	}
    	
    	TreeNode left  = node.left;
    	TreeNode right = node.right;
    	
    	if(left != null) {
    		traverse(left, level + 1);
    	}
    	
    	if(right != null) {
    		traverse(right, level + 1);
    	}
    }
}
