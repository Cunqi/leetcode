package com.cx363;

import java.util.Arrays;

public class SpiralMatrixII {
	private static final int LEFT = 1;
	private static final int RIGHT = 2;
	private static final int UP = 3;
	private static final int DOWN = 4;
    public int[][] generateMatrix(int n) {
    	
    	int[][] result = null;
    	if(n == 0) return new int[0][0];
    	if(n == 1){
    		result = new int[1][1];
    		result[0][0] = 1;
    		
    		return result;
    	}
    	
        result = new int[n][n];
        
        int step = 1;
        
        travel(result, step, RIGHT, 0, 0);
        
        return result;
    }
    
    private void travel(int[][] result, int step, int direction, int startI, int startJ) {
    	int i = startI;
    	int j = startJ;
    	
    	
    	while(true) {
    		if(result[i][j] == 0) {
    			result[i][j] = step++;	
    		}else{
    			break;
    		}
    		 
    		if(direction == RIGHT) {
    			if(j+1 < result.length && result[i][j+1] == 0) {
    				j++;
    			}else{
    				direction = DOWN;
    				i++;
    			}
    		}else if(direction == LEFT) {
    			if(j-1 >= 0 && result[i][j-1] == 0) {
    				j--;
    			}else {
    				direction = UP;
    				i--;
    			}
    			
    		}else if(direction == UP) {
    			if(i-1 >= 0 && result[i-1][j] == 0) {
    				i--;
    			}else {
    				direction = RIGHT;
    				j++;
    			}
    			
    		}else if(direction == DOWN) {
    			if(i+1 <result.length && result[i+1][j] == 0) {
    				i++;
    			}else {
    				direction = LEFT;
    				j--;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	SpiralMatrixII solution = new SpiralMatrixII();
    	
    	int[][] result = solution.generateMatrix(0);
    	
    	for(int i=0; i<result.length; i++) {
    		System.out.println(Arrays.toString(result[i]));
    	}
    }
}
