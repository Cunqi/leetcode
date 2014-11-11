package com.cx363.entity;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x) {
		this.val = x;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		
		TreeNode tmp = this;
		while(tmp != null) {
			builder.append(tmp.val);
			builder.append(",");
			
			tmp = tmp.right; 
		}
		
		builder.deleteCharAt(builder.length() - 1);
		builder.append("]");
		
		return builder.toString();
	}
}
