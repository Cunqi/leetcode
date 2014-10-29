package com.cx363.entity;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x){
		val = x;
		next = null;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		
		ListNode pNext = null;
		
		pNext = this;
		
		while(pNext != null){
			builder.append(pNext.val);
			builder.append(",");
			pNext = pNext.next;
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append("]");
		
		return builder.toString();
	}
}
