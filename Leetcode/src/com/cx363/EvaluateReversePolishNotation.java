package com.cx363;

import java.util.Stack;
public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
        
        Stack<String> s = new Stack<String>();
        Integer a, b;
        for(int i=0; i<tokens.length; i++){
        	s.push(tokens[i]);
        	
        	if(s.peek().equals("+")){
        		s.pop();	//symbol
        		b = Integer.valueOf(s.pop());
        		a = Integer.valueOf(s.pop());
        		
        		s.push(String.valueOf(a + b));
        	}else if(s.peek().equals("-")){
        		s.pop();
        		b = Integer.valueOf(s.pop());
        		a = Integer.valueOf(s.pop());
        		
        		s.push(String.valueOf(a - b));
        	}else if(s.peek().equals("*")){
        		s.pop();
        		b = Integer.valueOf(s.pop());
        		a = Integer.valueOf(s.pop());
        		
        		s.push(String.valueOf(a * b));
        	}else if(s.peek().equals("/")){
        		s.pop();
        		b = Integer.valueOf(s.pop());
        		a = Integer.valueOf(s.pop());
        		
        		s.push(String.valueOf(a / b));
        	}
        }
        
    	return Integer.valueOf(s.peek());
    }
}