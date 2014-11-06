package com.cx363;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.cx363.entity.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(null != root){
        	bfsTravel(root, 0, result);
        	
        	result= reverse(result);
        }
        
        return result;
    }
    
    private void bfsTravel(TreeNode root, int level, List<List<Integer>> result){
    	
    	Queue<TreeNode> maintain = new LinkedList<TreeNode>();
    	Queue<TreeNode> visited  = new LinkedList<TreeNode>();
    	List<Integer> list = null;
    	TreeNode tmp = null;
    	
    	maintain.offer(root);
    	
    	while(!maintain.isEmpty()){
    		
    		list = new ArrayList<Integer>();
    		
    		//get out from maintain
    		while(!maintain.isEmpty()){
    			list.add(maintain.peek().val);
    			
    			visited.offer(maintain.poll());
    		}
    		
    		result.add(list);
    		
    		//add sub-node to maintain
    		while(!visited.isEmpty()){
    			tmp = visited.poll();
    			
    			if(tmp.left  != null) maintain.offer(tmp.left);
    			if(tmp.right != null) maintain.offer(tmp.right);
    		}
    		
    	}
    }
    
    private List<List<Integer>> reverse(List<List<Integer>> result) {
    	List<List<Integer>> output = new ArrayList<List<Integer>>();
    	
    	for(int i = result.size() - 1; i >=0; i--){
    		output.add(result.get(i));
    	}
    	
    	return output;
    }
    
    public static void main(String[] args){
    	TreeNode n1 = new TreeNode(0);
    	TreeNode n2 = new TreeNode(1);
    	TreeNode n3 = new TreeNode(2);
    	TreeNode n4 = new TreeNode(3);
    	TreeNode n5 = new TreeNode(4);
    	TreeNode n6 = new TreeNode(5);
    	TreeNode n7 = new TreeNode(6);
    	TreeNode n8 = new TreeNode(7);
    	TreeNode n9 = new TreeNode(8);
    	
    	n1.left  = n2;
    	n1.right = n3;
    	n2.left  = n4;
    	n2.right = n5;
    	n3.left  = n6;
    	n3.right = n7;
    	n4.left  = n8;
    	n5.right = n9;
    	
    	BinaryTreeLevelOrderTraversalII solution = new BinaryTreeLevelOrderTraversalII();
    	
    	System.out.println(solution.levelOrderBottom(n1));
    }
    
    
}
