package com.cx363;

import com.cx363.entity.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
    	
    	if(null == head || null == head.next) return head;
    	
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode temp = null;
        ListNode tempMore = more;
        
        ListNode result = less;
        
        less.next = head;
        
        while(less != null && less.next != null) {
        	if(less.next.val >= x){
        		temp = less.next;
        		less.next = temp.next;
        		temp.next = null;
        		
        		tempMore.next = temp;
        		tempMore = tempMore.next;
        	}else {
        		less = less.next;
        	}
        }
        
        less.next = more.next;
        
        return result.next;
    }
    
    public static void main(String[] args){
    	PartitionList solution = new PartitionList();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(4);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(2);
    	ListNode n5 = new ListNode(5);
    	ListNode n6 = new ListNode(2);
    	
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	n5.next = n6;
    	
    	System.out.println(solution.partition(n1, 3));
    }
}
