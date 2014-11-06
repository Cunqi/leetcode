package com.cx363;

import com.cx363.entity.TreeNode;

public class MinimumDepthOfBinarySearch {
	private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
    	
    	if(null == root) return 0;
    	
    	dfs(root, 0);
    	
    	return minDepth;
    }
    
    private void dfs(TreeNode node, int level) {
    	if(node.left == null && node.right == null) {
    		minDepth = level < minDepth ? level : minDepth;
    		return;
    	}
    	
    	if(level > minDepth) return;
    	
    	if(null != node.left) {
    		dfs(node.left, level + 1);
    	}
    	
    	if(null != node.right) {
    		dfs(node.right, level + 1);
    	}
    }
}
