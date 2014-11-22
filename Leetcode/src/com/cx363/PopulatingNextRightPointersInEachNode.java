package com.cx363;

import com.cx363.entity.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
    	if(null == root) return;
    	TreeLinkNode temp = root.next;
    	
    	while(temp != null) {
    		if(temp.left != null) {
    			temp = temp.left;
    			break;
    		}
    		if(temp.right != null) {
    			temp = temp.right;
    			break;
    		}
    		
    		temp = temp.next;
    	}
    	
    	if(root.right != null) {
    		root.right.next = temp;
    	}
    	
    	if(root.left != null) {
    		root.left.next = root.right == null ? temp : root.right;
    	}
    	
    	connect(root.right);
    	connect(root.left);
    }
}
