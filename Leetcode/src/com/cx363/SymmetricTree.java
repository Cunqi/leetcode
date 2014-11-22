package com.cx363;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.cx363.entity.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	
    	if(null != root){
    		return travel(root);
    	}
        
    	return true;
    }
    
    private boolean travel(TreeNode root) {
    	Queue<TreeNode> mainQueue = new LinkedList<TreeNode>();
    	Queue<TreeNode> visited = new LinkedList<TreeNode>();
    	List<TreeNode> line = null;
    	TreeNode temp = null;
    	
    	mainQueue.offer(root);
    	
    	line = new ArrayList<TreeNode>();
    	while(!mainQueue.isEmpty()) {
    		
    		while(!mainQueue.isEmpty()) {
    			line.add(mainQueue.peek());
    			visited.offer(mainQueue.poll());
    		}
    		
    		if(checkLine(line, root) == false) {
    			return false;
    		}
    		line.clear();
    		
    		while(!visited.isEmpty()) {
    			temp = visited.poll();
    			
    			if(null != temp.left) mainQueue.offer(temp.left);
    			else if(temp.val != Integer.MIN_VALUE){
    				mainQueue.offer(new TreeNode(Integer.MIN_VALUE));
    			}
    			if(null != temp.right) mainQueue.offer(temp.right);
    			else if(temp.val != Integer.MIN_VALUE){
    				mainQueue.offer(new TreeNode(Integer.MIN_VALUE));
    			}
    		}
    	}
    	
    	return true;
    }
    
    private boolean checkLine(List<TreeNode> line, TreeNode root) {
    	
    	int low = 0;
    	int high = line.size() - 1;
    	
    	if(high == 0 && line.get(0) != root) {
    		return false;
    	}
    	
    	if(high > 0 && high % 2 == 0) return false;	//odd nodes can not be symmetric in tree
    	
    	while(low < high) {
    		if(line.get(low).val != line.get(high).val) {
    			return false;
    		}
    		
    		low++;
    		high--;
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(2);
    	TreeNode t4 = new TreeNode(3);
    	TreeNode t5 = new TreeNode(3);
    	
    	t1.left = t2;
    	t1.right = t3;
    	
    	t2.right = t4;
    	t3.right = t5;
    	
    	SymmetricTree solution = new SymmetricTree();
    	
    	System.out.println(solution.isSymmetric(t1));
    }
}
