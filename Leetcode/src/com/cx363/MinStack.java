package com.cx363;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	int min = Integer.MAX_VALUE;
    public void push(int x) {
        stack.push(x);
        
        if(x < min) min = x;
    }

    public void pop() {
        int tmp = stack.pop();
        
        if(tmp == min){
        	min = Integer.MAX_VALUE;
            for(Integer e : stack) {
            	if(e < min) {
            		min = e;
            	}
            }	
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
