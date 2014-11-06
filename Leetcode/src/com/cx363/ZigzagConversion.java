package com.cx363;

public class ZigzagConversion {
    public String convert(String s, int nRows) {
        if(null == s || s.length() == 0 || nRows <=0) return "";
        
        if(nRows == 1) return s;
        
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        int size = 2 * nRows - 2;
        
        for(int i=0; i<nRows; i++) {
        	for(int j=i; j< length; j += size){
        		builder.append(s.charAt(j));
        		if(i != 0 && i != nRows-1 && (j + size - 2 * i) < length) {
        			builder.append(s.charAt(j + size - 2 * i));
        		}
        	}
        }
        
        return builder.toString();
    }
    
    public static void main(String[] args) {
    	ZigzagConversion solution = new ZigzagConversion();
    	
    	System.out.println(solution.convert("PAYPALISHIRING", 3));
    }

}
