package com.amit.sorting;

public class MergeSortClass {
	public static void mergeSort(int[] array) {
		int[] helper = new int[array.length];
		MergeSortClass.mergeSort(array, helper, 0, array.length-1);
	}
	
	private static void mergeSort(int[] array, int[] helper, int low, int high) {
		int middle = 0;
		if (low < high) {
			middle = Math.abs((high+low)/2);
			MergeSortClass.mergeSort(array, helper, low, middle);
			MergeSortClass.mergeSort(array, helper, middle+1, high);
			MergeSortClass.merge(array, helper, low, high);
		}
	}

	private static void merge (int[] array, int[] helper, int low, int high) {
		
		for (int i = 0; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int middle = Math.abs((high+low)/2);
		int current = low;
		int lowLeft = low;
		int LowRight = middle+1;
		while ( lowLeft <= middle && LowRight <= high) {
			if (helper[lowLeft] < helper[LowRight]) {
				array[current] = helper[lowLeft];
				lowLeft++;
			}
			else {
				array[current] = helper[LowRight];
				LowRight++;
			}
			current++;
		}
		
		if (lowLeft < middle) {
			for(int i=lowLeft; i<=middle;i++,current++) {
				array[current] = helper[i];
			}
		}
	}
}
