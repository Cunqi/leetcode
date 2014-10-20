package com.cx363;

import com.cx363.entity.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode sorted = null;
        ListNode indicator = head;
        
        while(indicator != null){
        	sorted = insertIntoSortedList(sorted, indicator);
        	indicator = indicator.next;
        }
        
        return sorted;
    }
    
    private ListNode insertIntoSortedList(ListNode target, ListNode source){
    	//initialize
    	if(target == null){
    		target = new ListNode(source.val);
    	}else{
    		ListNode p = target;
    		
    		//if source is the smallest one.
    		if (target.val > source.val) {
				target = new ListNode(source.val);
				target.next = p;
			}else{
	    		while(p != null){
	    			ListNode pNext = p.next;
	    			
	    			//the last node in the list
	    			if(pNext == null){
	    				if(p.val < source.val){
	    					p.next = new ListNode(source.val);
	    				}else{
	    					ListNode element = new ListNode(p.val);
	    					p.val = source.val;
	    					p.next = element;
	    				}
	    			}else if(p.val <= source.val && source.val < pNext.val){
	    				ListNode element = new ListNode(source.val);
	    				p.next = element;
	    				element.next = pNext;
	    				break;
	    			}
	    			
	    			p = pNext;
	    		}
			}
    	}
    	
    	return target;
    }
    
    public static void main(String[] args){
    	InsertionSortList solution = new InsertionSortList();
    	
    	ListNode start = new ListNode(2);
    	ListNode n1 = new ListNode(8);
    	ListNode n2 = new ListNode(3);
    	ListNode n3 = new ListNode(7);
    	ListNode n4 = new ListNode(5);
    	ListNode n5 = new ListNode(5);
    	ListNode n6 = new ListNode(9);
    	ListNode n7 = new ListNode(1);
    	
    	start.next = n1;
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	n5.next = n6;
    	n6.next = n7;
    	
    	ListNode result = solution.insertionSortList(start);
    	
    	System.out.println(result);
    }
}
