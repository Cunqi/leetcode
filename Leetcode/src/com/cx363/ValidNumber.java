package com.cx363;

public class ValidNumber {
	public interface InputType {
		int INVALID = 0;
		int SPACE = 1;
		int SIGN = 2;
		int DIGIT = 3;
		int DOT = 4;
		int EXPONENT = 5;
	}
    public boolean isNumber(String s) {
    	int[][] stateMap = {
    			
    			{-1,  0,  3, 1,  2, -1},	//state 0
    			{-1,  8, -1, 1,  4,  5},	//state 1
    			{-1, -1, -1, 4, -1, -1},	//state 2
    			{-1, -1, -1, 1,  2, -1},	//state 3
    			{-1,  8, -1, 4, -1,  5},	//state 4
    			{-1, -1,  6, 7, -1, -1},	//state 5
    			{-1, -1, -1, 7, -1, -1},	//state 6
    			{-1,  8, -1, 7, -1, -1},	//state 7
    			{-1,  8, -1, -1,-1, -1}		//state 8
    	};
    	
		
		int length = s.length();
		int state = 0;
		int type = 0;
		for(int i=0; i<length; i++) {
			type = InputType.INVALID;
			
			if(s.charAt(i) == ' ') {
				type = InputType.SPACE;
			}
			
			if(s.charAt(i) == '+' || s.charAt(i) == '-') {
				type = InputType.SIGN;
			}
			
			if(s.charAt(i) == '.') {
				type = InputType.DOT;
			}
			
			if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
				type = InputType.EXPONENT;
			}
			
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				type = InputType.DIGIT;
			}
			
			state = stateMap[state][type];
			
			if(state == -1) return false;
		}
		
		return state == 1 || state == 4 || state == 7 || state == 8;
		
    }
    public static void main(String[] args) {
    	 ValidNumber solution = new ValidNumber();
    	 
    	 System.out.println(solution.isNumber(".1e"));
    }
}
