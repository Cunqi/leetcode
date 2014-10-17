package com.cx363;
/**
 * 
 * @author xiaocunqi
 *
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length() == 0 && s2.length() ==0){
    		
    		if(s3.length() != 0){
    			return false;
    		}
    		
    		return true;
    	}
    	
    	if(s1.length() == 0){
    		return s2.equals(s3);
    	}
    	
    	if(s2.length() == 0){
    		return s1.equals(s3);
    	}
    	
    	StringBuilder builder = new StringBuilder();
    	StringBuilder s3Builder = new StringBuilder(s3);
    	
    	for(int i=0; i< s1.length(); i++){
    		for(int k=0; k< s3.length(); k++){
    			if(s1.charAt(i) == s3.charAt(k)){
    				s3Builder.setCharAt(k, ' ');
    				break;
    			}
    		}
    	}
    	
    	for(int i=0; i<s3Builder.length(); i++){
    		if(s3Builder.charAt(i) != ' '){
    			builder.append(s3Builder.charAt(i));
    		}
    	}
    	
    	System.out.println(builder.toString());
    	
    	return s2.equals(builder.toString());
    }
    
    public static void main(String[] args){
    	String s1 = "ef";
    	String s2 = "gh";
    	String s3 = "ehgf";
    	
    	InterleavingString solution = new InterleavingString();
    	System.out.println(solution.isInterleave(s1, s2, s3));
    	
    	
    }
}
