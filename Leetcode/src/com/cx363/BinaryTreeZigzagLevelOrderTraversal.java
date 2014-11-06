package com.cx363;

import java.util.ArrayList;
import java.util.List;

import com.cx363.entity.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	boolean isLeft = true;
    	
    	if(null != root){
        	List<Integer> start = new ArrayList<Integer>();
        	start.add(root.val);
        	
        	result.add(start);
    		
    		zigzagTravel(root, result, !isLeft, 1);

    		result.remove(result.size() - 1);
    	}
    	
    	return result;
    }
    
    private void zigzagTravel(TreeNode node, List<List<Integer>> result, boolean isLeft, int level){

    	if(level == result.size()){
    		result.add(new ArrayList<Integer>());
    	}
    	
    	TreeNode left  = node.left;
    	TreeNode right = node.right;
    	List<Integer> list = result.get(level);
    	
    	addToList(list, left, right, isLeft);
    	
    	if(null != left)  zigzagTravel(left, result, !isLeft, level + 1);
    	if(null != right) zigzagTravel(right, result, !isLeft, level + 1);
    }
    
    private void addToList(List<Integer> list, TreeNode left, TreeNode right, boolean isLeft){
    	if(isLeft){
    		if(null != left)  list.add(left.val);
    		if(null != right) list.add(right.val);
    	}else{
    		if(null != left)  list.add(0, left.val);
    		if(null != right) list.add(0, right.val);
    	}
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
    	TreeNode n10 = new TreeNode(9);
    	
    	n1.left  = n2;
    	n1.right = n3;
    	n2.left  = n4;
    	n2.right = n5;
    	n3.left  = n6;
    	n3.right = n7;
    	n4.left  = n8;
    	n5.right = n9;
    	n9.left  = n10;
    	
    	BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
    	
    	System.out.println(solution.zigzagLevelOrder(n10));
    }
}
