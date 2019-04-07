package com.amit.sorting;

import java.util.ArrayList;

public class TestQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1000);
		array.add(900);
		array.add(800);
		array.add(700);
		array.add(600);
		array.add(500);
		array.add(50);
		array.add(400);
		array.add(300);
		array.add(200);
		array.add(100);
		array.add(5000);
		
		QuickSortClass sort = new QuickSortClass();
		sort.quickSort(array, 0, array.size() - 1);
		
		for (int i=0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		
	}

}
