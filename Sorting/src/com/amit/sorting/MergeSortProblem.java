/**
 * Problem Statement: Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 * Optimize the method for space.
 */

package com.amit.sorting;

import java.util.ArrayList;
import java.util.Iterator;

public class MergeSortProblem {
	
	
	private static void mergeSortBetter(ArrayList<Integer> bigArray, ArrayList<Integer> smallArray) {
		
		// Find the last filled element in the big Array
		int i = 0;
		while (bigArray.get(i) != null) {
			i++;
		}
		// position to the last element
		i--;
		int bigCounter = bigArray.size() - 1;
		int smallCounter = smallArray.size() - 1;
		
		while (smallCounter >= 0 && i>= 0) {
			if (bigArray.get(i) >= smallArray.get(smallCounter)) {
				bigArray.set(bigCounter, bigArray.get(i));
				i--;
				bigCounter--;
			}
			else {
				bigArray.set(bigCounter,  smallArray.get(smallCounter));
				smallCounter--;
				bigCounter--;
			}
		}
		// Copy over the remaining elements from small array to big array.
		while (i<0 && smallCounter >= 0) {
			bigArray.set(bigCounter, smallArray.get(smallCounter));
			bigCounter--;
			smallCounter--;
		}
	}
	//Merge Sort the 2 array in place without using another array of the same size as big array.
	private static void mergeSort(ArrayList<Integer> bigArray, ArrayList<Integer> smallArray) {
		
		int smallCounter = 0;
		int bigCounter = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		while ( smallCounter < smallArray.size() && bigArray.get(bigCounter) != null) {
			
			if (smallArray.get(smallCounter) < bigArray.get(bigCounter) && temp.isEmpty()) {
				temp.add(bigArray.get(bigCounter));
				bigArray.set(bigCounter, smallArray.get(smallCounter));
				bigCounter++;
				smallCounter++;
				continue;
			}
			if (smallArray.get(smallCounter) > bigArray.get(bigCounter) && temp.isEmpty()) {
				bigCounter++;
				continue;
			}
			if (smallArray.get(smallCounter) < bigArray.get(bigCounter) && !temp.isEmpty()) {
				if (temp.get(0) < smallArray.get(smallCounter)){
					temp.add(bigArray.get(bigCounter));
					bigArray.set(bigCounter, temp.remove(0));
					bigCounter++;
				}
				else {
					temp.add(bigArray.get(bigCounter));
					bigArray.set(bigCounter, smallArray.get(smallCounter));
					smallCounter++;
					bigCounter++;
				}
				continue;
			}
			if (smallArray.get(smallCounter) > bigArray.get(bigCounter) && !temp.isEmpty()) {
				if (temp.get(0) < bigArray.get(bigCounter)){
					temp.add(bigArray.get(bigCounter));
					bigArray.set(bigCounter, temp.remove(0));
				}
				bigCounter++;
				continue;
			}
		}
		
		if (smallCounter >= smallArray.size() && (bigArray.get(bigCounter) != null)) {
			// Small Array is exhausted. Now Copy over values from temp to big Array
			int bigCounter2 = bigArray.size()-1;
			int tempSize = temp.size();
			//Shift the remaining values in the array towards the end
			while (bigCounter2 >= bigCounter) {
				bigArray.set(bigCounter2 , bigArray.get(bigCounter2 - tempSize));
				bigCounter2--;
			}
			
			//Copy over the values from temp array to the space created in BigArray
			Iterator it = temp.iterator();
			while (it.hasNext()) {
				bigArray.set(bigCounter, (Integer) it.next());
				bigCounter++;
			}
			return;
		}
		
		while (smallCounter < smallArray.size() && !temp.isEmpty()) {
			if (smallArray.get(smallCounter) < temp.get(0)) {
				bigArray.set(bigCounter, smallArray.get(smallCounter));
				smallCounter++;
				bigCounter++;
			}
			else {
				bigArray.set(bigCounter, temp.remove(0));
				bigCounter++;
			}
		}
		//copy the remaining elements in SmallArray to BigArray
		while (smallCounter < smallArray.size()) {
			bigArray.set(bigCounter, smallArray.get(smallCounter));
			smallCounter++;
			bigCounter++;
		}
		
		
		//Copy the remaining elements in temp to bigArray
		if (temp.size() > 0 ) {
			Iterator it = temp.iterator();
			while (it.hasNext()) {
				bigArray.set(bigCounter, (Integer) it.next());
				bigCounter++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> bigArray = new ArrayList<Integer>();
		ArrayList<Integer> smallArray = new ArrayList<Integer>(5);
		
		
		bigArray.add(10);bigArray.add(20);bigArray.add(30);bigArray.add(40);bigArray.add(50);
		bigArray.add(60);bigArray.add(70);bigArray.add(80);
		bigArray.add(90);bigArray.add(100);bigArray.add(110);bigArray.add(120);bigArray.add(130);
		bigArray.add(null);bigArray.add(null);
		bigArray.add(null);bigArray.add(null);bigArray.add(null);
		
		smallArray.add(1);smallArray.add(2);smallArray.add(3);smallArray.add(4);smallArray.add(5);

		mergeSortBetter(bigArray, smallArray);
		
		Iterator it = bigArray.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
