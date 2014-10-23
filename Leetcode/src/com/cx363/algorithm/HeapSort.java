package com.cx363.algorithm;

import java.util.Arrays;

public class HeapSort {
	/**
	 * maintain the feature of a heap
	 * @param A
	 * @param position
	 * @return
	 */
	public int[] maxHeapify(int[] A, int position, int heapSize){
		int positionLeft  = left(position);
		int positionRight = right(position);
		
		int largest = position;	//store the largest element between left right and parent
		
		if(positionLeft <= heapSize && A[positionLeft] > A[largest]){
			largest = positionLeft;
		}
		
		if(positionRight <= heapSize && A[positionRight] > A[largest]){
			largest = positionRight;
		}
		
		if(largest != position){
			exchange(A, largest, position);
			
			maxHeapify(A, largest, heapSize);
		}
		
		return A;
	}
	
	public int[] buildMaxHeap(int[] A,int heapSize){
		
		for(int i = heapSize /2; i>=0; i--){
			maxHeapify(A, i, heapSize);
		}
		
		return A;
	}
	
	public int[] heapSort(int[] A){
		int heapSize = A.length - 1;
		
		buildMaxHeap(A, heapSize);
		
		for(int i=A.length-1; i>0 ;i--){
			exchange(A, 0, i);
			heapSize--;
			maxHeapify(A, 0, heapSize);
		}
		
		return A;
	}
	
	public static void main(String[] args){
		int[] data = {1, 6, 5,8, 11, 9, 22, 7, 91};
		
		HeapSort heapSort = new HeapSort();
		
		heapSort.heapSort(data);
		
		System.out.println(Arrays.toString(data));
	}
	
	private void exchange(int[] A, int source, int target){
		int temp  = A[source];
		A[source] = A[target];
		A[target] = temp;
	}
	
	private int parent(int position){
		return position / 2;
	}
	
	private int left(int position){
		return position * 2;
	}
	
	private int right(int position){
		return position * 2 + 1;
	}
}
