package com.cx363;

import com.cx363.entity.TreeNode;

public class SumRootToLeafNumbers {
	private int sum = 0;
    public int sumNumbers(TreeNode root) {
    	
    	if(null == root) return 0;
    	
    	calc(root, new StringBuilder());
    	
    	return sum;
    }
    
   private void calc(TreeNode node, StringBuilder builder) {
	   builder.append(node.val);
	   
	   if(node.left == null && node.right == null) {
		   sum += Integer.valueOf(builder.toString());
		   
		   return;
	   }else{
		   if(null != node.left){
			   calc(node.left, builder);
			   builder.deleteCharAt(builder.length() - 1);
		   }
		   
		   if(null != node.right){
			   calc(node.right, builder);
			   builder.deleteCharAt(builder.length() - 1);
		   }
	   }
	   
   }
    
    public static void main(String[] args) {
    	SumRootToLeafNumbers solution = new SumRootToLeafNumbers();
    	
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	TreeNode n3 = new TreeNode(3);
    	TreeNode n4 = new TreeNode(4);
    	TreeNode n5 = new TreeNode(5);
    	TreeNode n6 = new TreeNode(6);
    	TreeNode n7 = new TreeNode(7);
    	
    	n1.left = n2;
    	n2.left = n3;
    	n3.left = n4;
    	n1.right = n5;
    	n5.right = n6;
    	n6.right = n7;
    	
    	System.out.println(solution.sumNumbers(n6));
    }
}
