package com.cx363;

import com.cx363.entity.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
    	
    	ListNode oneStep = head;
    	ListNode twoStep = head;
    	
    	while(twoStep != null) {
    		
    		oneStep = oneStep.next;
    		twoStep = twoStep.next;
    		
    		if(null != twoStep) {
    			twoStep = twoStep.next;
    		}
    		
    		if(oneStep == twoStep) break;
    	}
    	
    	if(null == twoStep) return null;
    	
    	oneStep = head;
    	
    	while(oneStep != twoStep) {
    		oneStep = oneStep.next;
    		twoStep = twoStep.next;
    	}
        
    	
    	return twoStep;
    }
}
