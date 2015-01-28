package com.dolan.numberdifference;

import java.io.*;

public class Solution2 {
	private static int[] numberArray;
	
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		numberArray = new int[] { 1,3,5,2,4 };
		mergeSort(null, 0, 4);
	}
	
	private static void mergeSort(int[] numbers, int startIndex, int endIndex) {
		int middle = startIndex + (endIndex - startIndex) / 2;
		mergeSort(numbers, startIndex, middle);
		mergeSort(numbers, middle + 1, endIndex);
		
		merge(startIndex, middle, endIndex);
	}
	
	private static void merge(int startIndex, int middle, int endIndex) {
		int[] array = new int[endIndex - startIndex];
		int array1Counter = 0;
		int array2Counter = 0;
		int arrayCounter = 0;
		
		while (array1Counter != middle && array2Counter != endIndex) {
			if (array1Counter == middle) {
				array[arrayCounter] = numberArray[array2Counter];
				continue;
			}
			
			if (array2Counter == endIndex) {
				array[arrayCounter] = numberArray[array1Counter];
				continue;
			}
			
			if (numberArray[array1Counter] > numberArray[array2Counter]) {
				array[arrayCounter] = numberArray[array2Counter];
			} else {
				array[arrayCounter] = numberArray[array1Counter];
			}
		}
		
		arrayCounter = 0;
		for (int i = startIndex; i < endIndex; i++) {
			numberArray[i] = array[arrayCounter];
			arrayCounter++;
		}
	}
}