package com.cx363;

import com.cx363.entity.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
    	if(num.length == 0) return null;
    	
    	return sortTree(num, 0, num.length - 1);
    }
    
    private TreeNode sortTree(int[] num, int low, int high) {
    	
    	if(low > high) return null;
    	
    	int mid = (low + high) / 2;
    	
    	TreeNode root = new TreeNode(num[mid]);
    	
    	root.left = sortTree(num, low, mid - 1);
    	root.right = sortTree(num, mid + 1, high);
    	
    	return root;
    }
    
    public static void main(String[] args) {
    	int[] num = {1, 2, 3, 4, 5, 6, 7};
    	
    	ConvertSortedArrayToBinarySearchTree solution = new ConvertSortedArrayToBinarySearchTree();
    	
    	TreeNode result = solution.sortedArrayToBST(num);
    	
    	System.out.println(result);
    }
}
