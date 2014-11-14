package com.cx363;

import java.util.LinkedList;
import java.util.Queue;

import com.cx363.entity.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
    	if(null != root) {
    		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    		Queue<TreeLinkNode> visited = new LinkedList<TreeLinkNode>();
    		
    		TreeLinkNode tmp = null;
    		
    		queue.offer(root);
    		
    		while(!queue.isEmpty()) {
    			
    			tmp = null;
    			while(!queue.isEmpty()) {
    				
    				if(tmp == null){
    					tmp = queue.peek();
    				}else {
    					tmp.next = queue.peek();
    					tmp = tmp.next;
    				}
    				visited.offer(queue.poll());
    			}
    			tmp = null;
    			
    			while(!visited.isEmpty()) {
    				tmp = visited.poll();
    				
    				if(tmp.left != null) queue.offer(tmp.left);
    				if(tmp.right != null) queue.offer(tmp.right);
    			}
    		}
    	}
    }
}
