package com.amit.sorting;

public class TestMergeSort {

	public static void main(String[] args) {
		
		int[] array = { 3,2,7,89,32,44,200,12,30};
		MergeSortClass.mergeSort(array);
		for (int i = 0 ;i<array.length; i++) {
			System.out.println(array[i]);

		}
	}
}
