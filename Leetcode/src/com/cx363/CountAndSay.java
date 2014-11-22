package com.cx363;

public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder builder = new StringBuilder("1");
        
        if(n == 0) return builder.toString();
        
        StringBuilder result = new StringBuilder();
        StringBuilder temp = null;
        int count = 1;
        char tmp = 0;
        
        for(int i=0; i<n-1; i++) {
        	count = 1;
        	for(int j=0; j<builder.length(); j++) {
        		if(j==0) {
        			tmp = builder.charAt(j);
        		}else if(tmp == builder.charAt(j)) {
        			count++;
        		}else {
        			result.append(count);
        			result.append(tmp);
        			count = 1;
        			tmp = builder.charAt(j);
        		}
        		
        		if(j == builder.length() - 1) {
        			result.append(count);
        			result.append(tmp);
        		}
        	}
        	temp = builder;
        	builder = result;
        	result = temp;
        	result.delete(0, result.length());
        }
        
        return builder.toString();
    }
    
    public static void main(String[] args) {
    	CountAndSay solution = new CountAndSay();
    	
    	System.out.println(solution.countAndSay(1));
    }
}
