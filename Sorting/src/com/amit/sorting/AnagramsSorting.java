/**
 * Problem statement: Write a method to sort an array of strings so that all the anagrams are next to each other.
 */


package com.amit.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AnagramsSorting {

	private static boolean compareAnagrams(String string1, String string2) {
		
		HashMap<String, Integer> map1 = getMap(string1);
		HashMap<String,Integer> map2 = getMap(string2);
		
		if (map1.equals(map2)) {
			return true;
		}
		else
			return false;
	}
	
	private static HashMap<String, Integer> getMap(String string1){
		int length = string1.length();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0 ; i<length; i++) {
			String s = Character.toString(string1.charAt(i));
			if (map.get(s) == null) {
				map.put(s, 1);
			}
			else {
				int newVal = map.get(s) + 1;
				map.put(s,newVal);
			}
		}
		return map;
	}
	
	public static void sortAnagrams(ArrayList<String> array) {
		int length = array.size();
		int j = 0;
		for (int i = 0 ; i < length-2; i=j) {
			j = i+1;
			while (compareAnagrams(array.get(i), array.get(j)) && j<length) {
				j++;
			}
			// the element at position j is not equal to i
			
			for (int k = j+1; k<=length-1; k++) {
				if (compareAnagrams(array.get(i), array.get(k))){
					String temp = array.get(j);
					array.set(j,array.get(k));
					array.set(k, temp);
					j++;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("listen");
		array.add("car");
		array.add("tar");
		array.add("study");
		array.add("arc");
		array.add("taste");
		array.add("elbow");
		
		array.add("state");
		
		array.add("dusty");
		
		array.add("below");
		array.add("rat");
		array.add("silent");
		System.out.println("ARRAY BEFORE SORTING");
		Iterator it = array.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		AnagramsSorting.sortAnagrams(array);
		System.out.println("_____________________________________________");
		System.out.println("ARRAY AFTER SORTING");
		
		it = array.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
