package com.cx363;

import java.math.BigDecimal;

import com.cx363.entity.ListNode;

public class SwapNodesInPairs {
	private ListNode h;
    public ListNode swapPairs(ListNode head) {
    	if(null == head || head.next == null) return head;
    	
    	this.h = new ListNode(0);
    	this.h.next = head;
    	
    	ListNode source = h;
    	
    	while(source != null && source.next != null) {
    		source = exchange(source);
    	}
    	
    	return h.next;
    }
    
    private ListNode exchange(ListNode start) {
    	ListNode source = start.next;
    	ListNode target = source.next;
    	
    	if(target == null) return null;
    	
    	ListNode subTarget = target.next;
    	
    	start.next = target;
    	target.next = source;
    	source.next = subTarget;
    	
    	return source;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	
    	SwapNodesInPairs solution = new SwapNodesInPairs();
    	
    	System.out.println(solution.swapPairs(n1));
    	
    	System.out.println(new BigDecimal("1.e1".trim()).toString());
    	
    }
}
