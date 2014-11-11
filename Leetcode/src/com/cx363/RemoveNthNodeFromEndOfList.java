package com.cx363;

import com.cx363.entity.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(null == head) return head;
        
        ListNode result = new ListNode(0);
        result.next = head;
        
        int length = getLengthOfList(head);
        int moves = length - n;
        
        ListNode pointer = result;
        int index = 0;
        
        while(index < moves) {
        	pointer = pointer.next;
        	index++;
        }
        
        ListNode temp = pointer.next;
        pointer.next = temp.next;
        temp.next = null;
        
        return result.next;
    }
    
    private int getLengthOfList(ListNode tmp) {
    	int length = 0;
    	while(tmp != null) {
    		length++;
    		tmp = tmp.next;
    	}
    	
    	return length;
    }
    
    public static void main(String[] args) {
    	RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	
    	System.out.println(solution.removeNthFromEnd(n5, 1));
    }
}
