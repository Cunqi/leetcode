package com.cx363;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean zeroRow = false;
        boolean zeroCol = false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        //column
        for(int i=0; i<m; i++) {
        	if(matrix[i][0] == 0) {
        		zeroCol = true;
        		break;
        	}
        }
        //row
        for(int i=0; i<n; i++) {
        	if(matrix[0][i] == 0) {
        		zeroRow = true;
        		break;
        	}
        }
        
        //set the row and column should be set zero
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		if((matrix[i][j]) == 0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0; 
        		}
        	}
        }
        
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		if(matrix[i][0] == 0 || matrix[0][j] == 0) {
        			matrix[i][j] = 0; 
        		}
        	}
        }
        
        if(zeroRow) {
        	for(int i=0; i<n; i++) {
        		matrix[0][i] = 0; 
        	}
        }
        
        if(zeroCol) {
        	for(int i=0; i<m; i++) {
        		matrix[i][0] = 0;
        	}
        }
    }
    
    public static void main(String[] args) {
    	SetMatrixZeroes solution = new SetMatrixZeroes();
    	int[][] data = {{0, 1}};
    	solution.setZeroes(data);
    	System.out.println(Arrays.toString(data[0]));
    }
}
