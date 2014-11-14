package com.cx363;

import com.cx363.entity.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    	
    	if(null == head || head.next == null) return head;
    	
        ListNode current  = new ListNode(0);
        current.next = head;
        ListNode result = current;
        ListNode normal = current.next;
        ListNode compared = normal.next;
        
        boolean isDuplicated = false;
        
        while(null != compared) {
        	if(normal.val == compared.val) {
        		current.next = null;
        		isDuplicated = true;
        	}else {
        		if(isDuplicated) {
        			current.next = compared;
        			normal = compared;
        			isDuplicated = false;
        		}else {
        			current = normal;
        			normal = current.next;
        		}
        	}
        	
        	compared = compared.next;
        }
        
        return result.next;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(1);
    	ListNode n3 = new ListNode(2);
    	ListNode n4 = new ListNode(3);
    	ListNode n5 = new ListNode(1);
    	
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	
    	System.out.println(solution.deleteDuplicates(n3));
    }
}
