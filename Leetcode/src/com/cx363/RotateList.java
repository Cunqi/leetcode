package com.cx363;

import com.cx363.entity.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(null == head || null == head.next) return head;
        
        int length = getLengthOfList(head);
        
        ListNode tail = getTailOfNode(head);
        tail.next = head;
        
        ListNode pivot = getRotateNode(head, length - n % length);
        
        return pivot;
    }
    
    private int getLengthOfList(ListNode tmp) {
    	int length = 0;
    	while(tmp != null) {
    		length++;
    		tmp = tmp.next;
    	}
    	
    	return length;
    }
    
    private ListNode getRotateNode(ListNode head, int length) {
    	ListNode tmp = head;
    	
    	while(length != 1) {
    		length -= 1;
    		
    		tmp = tmp.next;
    	}
    	
    	ListNode result = tmp.next;
    	tmp.next = null;
    	
    	return result;
    }
    
    private ListNode getTailOfNode(ListNode node) {
    	ListNode tail = node;
    	
    	while(tail.next != null){
    		tail = tail.next;
    	}
    	
    	return tail;
    }
    
    public static void main(String[] args) {
    	RotateList solution = new RotateList();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	
    	System.out.println(solution.rotateRight(n1, 0));
    }
}
