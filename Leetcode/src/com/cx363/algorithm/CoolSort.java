package com.cx363.algorithm;

import java.util.Arrays;

public class CoolSort {
	private int[] A = null;
	public int[] coolSort(int[] a){
		A = a;
		int low  = 0;
		int high = A.length - 1;
		
		sort(A, low, high);
		
		return A;
	}
	
	private void sort(int[] A, int low, int high){
		if(high - low == 1){
			if(A[high] < A[low]) {
				exchange(A, low, high);
			}
		}
		
		if(high - low > 1) {
			int mid = (int)Math.ceil(2.0 * (high - low + 1) / 3.0);
			sort(A, low, low + mid - 1);
			sort(A, high - mid + 1, high);
			sort(A, low, low + mid - 1);
		}
	}
	
	private void exchange(int[] A, int source, int target){
		int temp = A[source];
		A[source] = A[target];
		A[target] = temp;
	}
	
	public static void main(String[] args){
		int[] data = {1, 3, 5, 4, 8, 7, 9};
		
		CoolSort solution = new CoolSort();
		
		System.out.println(Arrays.toString(solution.coolSort(data)));
		
		System.out.println(Math.ceil(3 / 2));
	}
}
