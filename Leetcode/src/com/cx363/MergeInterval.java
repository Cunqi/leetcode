package com.cx363;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cx363.entity.Interval;

public class MergeInterval {
	
    public List<Interval> merge(List<Interval> intervals) {
    	
    	int size = intervals.size();
    	
    	if(size <= 1) return intervals;
    	
    	Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval A, Interval B) {
				if(A.start < B.start) return -1;
				if(A.start > B.start) return 1;
				return 0;
			}
    	});
    	
    	List<Interval> result = new ArrayList<Interval>();
    	
    	Interval element = intervals.get(0);
    	
    	for(int i=1; i < size; i++){
    		Interval temp = intervals.get(i);
    		
    		//handle special case
    		if(element.end < temp.start){
    			result.add(element);
    			element = new Interval(temp.start, temp.end);
    			
    		}if(element.end < temp.end){
    			element.end = temp.end;
    		}
    	}
    	
    	result.add(element);
    	
    	return result;
    }
}
