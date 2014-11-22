package com.cx363;

import com.cx363.entity.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
    	
    	if(null == root) return true;
    	
        return travelTree(root) != -1;
    }
    
    private int travelTree(TreeNode node) {
    	if(node == null) return 0;
    	
    	int left = travelTree(node.left);
    	if(left == -1) return -1;
    	
    	int right = travelTree(node.right);
    	if(right == -1) return -1;
    	
    	if(Math.abs(left - right) > 1) return -1;
    	
    	return left > right ? left + 1 : right + 1;
    }
    
    public static void main(String[] args){
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	TreeNode n3 = new TreeNode(3);
    	TreeNode n4 = new TreeNode(4);
    	TreeNode n5 = new TreeNode(5);
    	TreeNode n6 = new TreeNode(6);
    	TreeNode n7 = new TreeNode(7);
    	TreeNode n8 = new TreeNode(8);
    	TreeNode n9 = new TreeNode(9);
    	
    	n1.left  = n2;
    	n1.right = n3;
    	n2.left  = n4;
    	n2.right = n5;
    	n3.left  = n6;
    	n3.right = n7;
    	n4.left  = n8;
    	n5.right = n9;
    	
    	BalancedBinaryTree solution = new BalancedBinaryTree();
    	
    	System.out.println(solution.isBalanced(n1));
    }
}
