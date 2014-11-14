package com.cx363;

import com.cx363.entity.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(null == p && null == q) return true;
        if(null == p || null == q) return false;
        
        return travelAndCompare(p, q);
    }
    
    private boolean travelAndCompare(TreeNode p, TreeNode q) {
    	boolean l,r;
    	
    	if(p.val != q.val) return false;
    	else if(isLeave(p) && isLeave(q)) {
    		return true;
    	}
    	
    	if(p.left != null && q.left != null) {
    		l = travelAndCompare(p.left, q.left);
    	}else {
    		if(p.left == null && q.left == null) l = true;
    		else {
    			l = false;
    		}
    	}
    	
    	if(l == false) return l;
    	
    	if(p.right != null && q.right != null) {
    		r = travelAndCompare(p.right, q.right);
    	}else {
    		if(p.right == null && q.right == null) r = true;
    		else {
    			r = false;
    		}
    	}
    	
    	return r;
    }
    
    private boolean isLeave(TreeNode node) {
    	if(node.left == null && node.right == null) return true;
    	
    	return false;
    }
}
