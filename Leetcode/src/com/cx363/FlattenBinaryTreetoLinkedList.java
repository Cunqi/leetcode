package com.cx363;

import com.cx363.entity.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        
        if(null != root){
        	transformTree(root);
        	//mergeToRight(root);
        }
    }
    
    private void transformTree(TreeNode node) {
    	
    	TreeNode left  = node.left;
    	TreeNode right = node.right;
    	
    	reverse(node);
    	
    	if(left  != null) transformTree(left);
    	
    	if(right != null) transformTree(right);
    	
    	mergeToRight(node);
    }
    
    private void reverse(TreeNode node) {
    	if(node.left != null) {
    		TreeNode tmp = node.left;
    		node.left = node.right;
    		node.right = tmp;
    	}
    }
    
    private void mergeToRight(TreeNode node) {
    	TreeNode leave = getRightTreeNode(node);
    	leave.right = node.left;
    	node.left   = null;
    }
    
    private TreeNode getRightTreeNode(TreeNode node) {
    	TreeNode tmp = node;
    	while(tmp.right != null){
    		tmp = tmp.right;
    	}
    	
    	return tmp;
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
    	
    	FlattenBinaryTreetoLinkedList solution = new FlattenBinaryTreetoLinkedList();
    	solution.flatten(n1);
    	System.out.println(n1);
    }
}
