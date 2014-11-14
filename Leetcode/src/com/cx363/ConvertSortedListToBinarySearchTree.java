package com.cx363;

import com.cx363.entity.ListNode;
import com.cx363.entity.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	
    	int length = getLength(head);
    	
    	return sortTree(head, 0, length - 1);
    }
    
    private TreeNode sortTree(ListNode head, int low, int high) {
    	
    	if(low > high) return null;
    	
    	int mid = (low + high) / 2;
    	
    	System.out.println(low + ", " + mid + ", " + high);
    	
    	ListNode midNode = getNodeAt(head, mid - low);
    	
    	TreeNode root = new TreeNode(midNode.val);
    	
    	root.left = sortTree(head, low, mid - 1);
    	root.right = sortTree(midNode.next, mid + 1, high);
    	
    	return root;
    }
    
    private ListNode getNodeAt(ListNode head, int position) {
    	ListNode temp = head;
    	for(int i=0; i<position; i++) {
    		temp = temp.next;
    	}
    	
    	return temp;
    	
    }
    
    private int getLength(ListNode head) {
    	int count = 0;
    	
    	while(head != null) {
    		head = head.next;
    		count++;
    	}
    	
    	return count;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	ListNode n6 = new ListNode(6);
    	ListNode n7 = new ListNode(7);
    	
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	n5.next = n6;
    	n6.next = n7;
    	
    	ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
    	
    	TreeNode result = solution.sortedListToBST(n1);
    	
    	System.out.println(result);
    }
}
