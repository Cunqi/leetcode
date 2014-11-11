package com.cx363;

import com.cx363.entity.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode left  = l1;
    	ListNode right = l2;
    	
    	if(null == l1 && null != l2) return l2;
    	if(null == l2 && null != l1) return l1;
    	if(null == l1 && null == l2) return null;
    	
    	ListNode result = new ListNode(0);
    	ListNode position = result;
    	
    	int lVal = 0;
    	int rVal = 0;
    	
    	while(null != left || null != right) {
    		if(left != null) {
    			lVal = left.val;
    		}else{
    			lVal = Integer.MAX_VALUE;
    		}
    		
    		if(right != null) {
    			rVal = right.val;
    		}else {
    			rVal = Integer.MAX_VALUE;
    		}
    		
    		if(lVal < rVal) {
    			position.next = left;
    			position = position.next;
    			
    			left = left.next;
    			
    			position.next = null;
    			
    		}else if(lVal >= rVal) {
    			position.next = right;
    			position = position.next;
    			
    			right = right.next;
    			
    			position.next = null;
    		}
    	}
    	
    	return result.next;
    }
    
    public static void main(String[] args) {
    	MergeTwoSortedLists solution = new MergeTwoSortedLists();
    	
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(3);
    	ListNode n3 = new ListNode(4);
    	ListNode n4 = new ListNode(0);
    	
    	n1.next = n2;
    	n2.next = n3;
    	
    	System.out.println(solution.mergeTwoLists(n1, n4));
    }
}
