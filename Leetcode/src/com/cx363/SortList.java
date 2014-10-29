
package com.cx363;

import com.cx363.entity.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
    	
    	if(null == head) return null;
    	
    	ListNode result = sort(head);
    	
        return result;
    }
    
    private ListNode sort(ListNode head){
    	
    	if(head == null || head.next == null){
    		return head;
    	}
    	
    	ListNode mid = findMid(head);
    	
    	ListNode right = mid.next;
    	mid.next = null;
    	
    	ListNode left = head;
    	
    	left  = sort(left);
    	
    	right = sort(right);
    	
    	ListNode result = merge(left, right);
    	
    	
    	return result;
    }
    
    private ListNode merge(ListNode left, ListNode right){
    	ListNode result = new ListNode(-1);
    	ListNode current = result;
    	
    	while(left != null || right != null){
    		int lval = left  == null ? right.val + 1 : left.val;
    		int rval = right == null ? left.val  + 1 : right.val;
    		
    		if(lval < rval){
    			current.next = left;
    			left = left.next;
    		}else{
    			current.next = right;
    			right = right.next;
    		}
    		
    		current = current.next;
    	}
    	return result.next;
    }
    
    private ListNode findMid(ListNode head){
    	ListNode oneStep = head;
    	ListNode twoStep = head;
    	
    	while(oneStep.next != null && twoStep.next != null && twoStep.next.next != null){
    		twoStep = twoStep.next;
    		
    		if(twoStep == null){
    			break;
    		}
    		
    		twoStep = twoStep.next;
    		oneStep = oneStep.next;
    	}
    	return oneStep;
    }
    
    
    public static void main(String[] args){
    	ListNode a = new ListNode(8);
    	ListNode b = new ListNode(7);
    	ListNode c = new ListNode(6);
    	ListNode d = new ListNode(5);
    	ListNode e = new ListNode(4);
    	ListNode f = new ListNode(3);
    	ListNode g = new ListNode(2);
    	ListNode h = new ListNode(1);
    	ListNode i = new ListNode(0);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	e.next = f;
    	f.next = g;
    	g.next = h;
    	h.next = i;
    	
    	SortList solution = new SortList();
    	
    	System.out.println(solution.sortList(h));
    }
}