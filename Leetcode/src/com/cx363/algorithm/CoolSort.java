package com.cx363.algorithm;

public class CoolSort {
	public int[] coolSort(int[] A){
		int low = 0;
		int high = A.length - 1;
		sort(A, low, high);
		return A;
	}
	
	private void sort(int[] A, int low, int high){
		if(high == low){
		}
		
		else if(high - low == 1){
			if(A[high] < A[low]){
				exchange(A, low, high);
			}
		}else{
			
		}
	}
	
	private void exchange(int[] A, int source, int target){
		int temp = A[source];
		A[source] = A[target];
		A[target] = temp;
	}
}
