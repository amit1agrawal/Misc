package com.amit.sorting;

import java.util.ArrayList;

public class QuickSortClass {
	
	
	private int partition(ArrayList<Integer> array, int low, int high) {
		int pivot = low;
		
		while (low < high) {
			// find an element which should be 
			while (array.get(pivot)  > array.get(low) )
				low++;
			
			while (array.get(pivot) < array.get(high))
				high--;
			if (low < high) {
				swap(array, low, high);
				low++;
				high--;
			}
		}
		swap(array, pivot, high);
		
		return high;
		
	}
	
	private void swap (ArrayList<Integer> array , int a, int b) {
		int temp = array.get(a);
		array.set(a, array.get(b));
		array.set(b, temp);
	}
	
	public void quickSort(ArrayList<Integer> array, int low, int high) {
		
		if (low < high) {
			int index = partition(array, low, high);
			quickSort(array, low, index-1);
			quickSort(array, index+1, high);
		}
	}
}
