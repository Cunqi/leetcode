package com.cx363;

import java.util.ArrayList;
import java.util.List;

public class SpiralNumber {
	int[][] status;
    public List<Integer> spiralOrder(int[][] matrix) {
    	
    	if(matrix.length == 0) return new ArrayList<Integer>();
    	
        List<Integer> result = new ArrayList<Integer>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        status = new int[m][n];
        
        //init
        Location current = new Location(0, 0, Location.RIGHT);
        result.add(matrix[0][0]);
        
        while(true){
        	current = whereToGo(current, m, n);
        	
        	if(current.direction == Location.STOP){
        		break;
        	}else{
        		result.add(matrix[current.r][current.c]);
        	}
        }
        
        
        return result;
    }
    
    private Location whereToGo(Location current, int m, int n){
    	
    	status[current.r][current.c] = 1;	//used
    	
    	if(current.direction == Location.RIGHT){
    		if(current.c+1 < n && status[current.r][current.c + 1] == 0){
    			return new Location(current.r, current.c + 1, current.direction);
    		}else{
    			//change direction
    			current.direction = Location.DOWN;
    		}
    	}
    	
    	if(current.direction == Location.DOWN){
    		if(current.r + 1 < m && status[current.r + 1][current.c] == 0){
    			return new Location(current.r + 1, current.c, current.direction);
    		}else{
    			current.direction = Location.LEFT;
    		}
    	}
    	
    	if(current.direction == Location.LEFT){
    		if(current.c-1 >= 0 && status[current.r][current.c - 1] == 0){
    			return new Location(current.r, current.c - 1, current.direction);
    		}else{
    			//change direction
    			current.direction = Location.UP;
    		}
    	}
    	
    	if(current.direction == Location.UP){
    		if(current.r - 1 >= 0 && status[current.r - 1][current.c] == 0){
    			return new Location(current.r - 1, current.c, current.direction);
    		}else{
    			current.direction = Location.RIGHT;
    		}
    	}
    	
    	//special case of handling turn from up to right
    	if(current.direction == Location.RIGHT){
    		if(current.c+1 < n && status[current.r][current.c + 1] == 0){
    			return new Location(current.r, current.c + 1, Location.RIGHT);
    		}
    	}
    	
    	
    	return new Location(-1,  -1, Location.STOP);
    }
    
    class Location {
    	public static final int RIGHT = 1;
    	public static final int DOWN = 2;
    	public static final int LEFT = 3;
    	public static final int UP = 4;
    	
    	public static final int STOP = -1;
    	public Location(int r, int c, int direction) {
    		this.r = r;
    		this.c = c;
    		this.direction = direction;
		}
    	int r;
    	int c;
    	int direction;
    }
    
    public static void main(String[] args){
    	SpiralNumber solution = new SpiralNumber();
    	
    	int[][] matrix = {{1}};
    	List<Integer> list = solution.spiralOrder(matrix);
    	
    	System.out.println(list);
    }
}
