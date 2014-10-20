package com.cx363.algorithm;

import java.util.Random;

public class QuickSort {
	public static final int ASCENT = 0;
	public static final int DESCENT = 1;
	
	public int[] sort(int[] data, int order){
		int low = 0;
		int high = data.length;
		
		Random random = new Random(System.currentTimeMillis());
		
		quickSort(data, low, high - 1, order, random);
		return data;
	}
	
	private void quickSort(int[] data, int low, int high, int order, Random random){
		if(low < high){
			int sentry = partition(data, low, high, order, random);
			quickSort(data, low, sentry-1, order, random);
			quickSort(data, sentry+1, high, order, random);
		}
	}
	
	private int partition(int[] data, int low, int high , int order, Random random){
		int p = low + random.nextInt(high - low + 1);	//important
		int sentry = data[p];
		
		swipe(data, p, high);
		
		int index = low;
		
		for(int i=low; i<high; i++){
			if(QuickSort.ASCENT == order){
				if(data[i] <= sentry){
					swipe(data, index, i);
					index++;
				}
			}else{
				if(data[i] >= sentry){
					swipe(data, index, i);
					index++;
				}
			}
		}
		
		swipe(data, index, high);
		
		
		return index;
	}
	
	private void swipe(int[] data, int source, int target){
		int temp = data[source];
		data[source] = data[target];
		data[target] = temp;
	}
	
	public static void main(String[] args){
		int[] data = {2, 1, 3, 5, 8, 19, 77, 4, 9};
		
		QuickSort quickSort = new QuickSort();
		
		int[] result = quickSort.sort(data, QuickSort.ASCENT);
		
		for(int a : result){
			System.out.print(a+",");
		}
	}
}
