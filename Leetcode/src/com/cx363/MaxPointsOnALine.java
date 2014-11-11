package com.cx363;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.cx363.entity.Point;

public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        Map<Double, Integer> statistic = new HashMap<Double, Integer>();
        int maxNum = 0;
        int duplicate = 1;
        double k = 0.0;
        for(int i=0; i < points.length; i++) {
        	statistic.clear();
        	statistic.put(Double.MIN_VALUE, 0); //itself
        	duplicate = 1;
        	for(int j=0; j < points.length; j++) {
        		if(i == j) continue;
        		
        		if(points[i].x == points[j].x && points[i].y == points[j].y) {
        			duplicate++;
        			continue;
        		}
        		
        		k = getK(points[i], points[j]);
        		
        		if(statistic.containsKey(k)){
        			statistic.put(k, statistic.get(k) + 1);
        		}else{
        			statistic.put(k, 1);
        		}
        	}
        	
        	Collection<Integer> list =statistic.values();
        	for(Integer element : list) {
        		if(element + duplicate > maxNum) {
        			maxNum = element + duplicate;
        		}
        	}
        }
        return maxNum;
    }
    
    private double getK(Point A, Point B) {
    	if(A.x == B.x) return Double.MAX_VALUE;
    	else {
    		int y = B.y - A.y;
    		int x = B.x - A.x;
    		
    		return y * 1.0 / x;
    	}
    }
    
    public static void main(String[] args) {
    	MaxPointsOnALine solution = new MaxPointsOnALine();
    	Point[] points = {new Point(0, 0)};
    	System.out.println(solution.maxPoints(points));
    }
}
