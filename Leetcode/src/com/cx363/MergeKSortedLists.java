package com.cx363;

import java.util.ArrayList;
import java.util.List;

import com.cx363.entity.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
    	ListNode result = null;
    	
    	int low = 0;
    	int high = lists.size()-1;
    	
    	if(high >= 0) {
//    		int mid = (low + high) / 2;
//    		
//    		ListNode left = sort(lists, low, mid);
//    		ListNode right = sort(lists, mid + 1, high);
//    		result = merge(left, right);
    		
    		result = sort(lists, low, high);
    	}
    	
        return result;
    }
    
    private ListNode sort(List<ListNode> lists, int low, int high) {
    	if(low == high){
    		return lists.get(low);
    	}
    	
    	int mid = (low + high) / 2;
    	
    	ListNode left = sort(lists, low, mid);
    	ListNode right = sort(lists, mid+1, high);
    	
    	ListNode result = merge(left, right);
    	
    	return result;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
    	
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
    	MergeKSortedLists solution = new MergeKSortedLists();
    	
    	List<ListNode> data = new ArrayList<ListNode>();
    	
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(5);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(7);
    	ListNode n6 = new ListNode(6);
    	
    	data.add(n1);
    	data.add(n2);
    	data.add(n3);
    	data.add(n4);
    	data.add(n5);
    	data.add(n6);
    	
    	System.out.println(solution.mergeKLists(data));
    }
}
