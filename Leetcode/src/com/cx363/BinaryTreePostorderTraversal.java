package com.cx363;

import java.util.ArrayList;
import java.util.List;

import com.cx363.entity.TreeNode;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	
        List<Integer> result = new ArrayList<Integer>();
        
        if(null != root){
        	travelTree(root, result);
        }
        
        return result;
    }
    
    private void travelTree(TreeNode node, List<Integer> result) {
    	
    	TreeNode left  = node.left;
    	TreeNode right = node.right;
    	
    	//travel left
    	if(null != left) travelTree(left, result);
    	
    	//travel right
    	if(null != right) travelTree(right, result);
    	
    	//record
    	result.add(node.val);
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
    	
    	BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();
    	
    	System.out.println(solution.postorderTraversal(n1));
    }
}
