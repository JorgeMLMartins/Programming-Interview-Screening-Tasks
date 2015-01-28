package com.dolan.numberdifference;

import java.util.Scanner;


public class Solution {
	private static int[] array;
	private static int[] temporaryArray;
	private static int length;

	public static void main(String args[]) {
		//int[] inputArr = { 1, 3, 2, 5, 4 };
		Scanner in = new Scanner(System.in);

		System.out.println("Enter numbers");
		String[] input1 = in.nextLine().split("\\s+");
		String[] input2 = in.nextLine().split("\\s+");
		int[] inputArr = toIntArray(input2);

		sort(inputArr);
		System.out.println(doTask(inputArr, Integer.parseInt(input1[1])));
	}
	
	private static int[] toIntArray(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		return intArray;
	}

	private static int doTask(int[] numbers, int k) {
		int count = 0;
		int slowPointer = 0;
		int fastPointer = 1;
		while (fastPointer < numbers.length) {
			int difference = Math.abs(numbers[slowPointer]
					- numbers[fastPointer]);
			if (difference == k) {
				count++;
				slowPointer++;
				fastPointer++;
			} else {
				fastPointer++;
			}
		}
		return count;
	}

	private static void resetAlgorithm(int inputArr[]) {
		array = inputArr;
		length = inputArr.length;
		temporaryArray = new int[length];
	}

	public static void sort(int inputArr[]) {
		resetAlgorithm(inputArr);
		mergeSort(0, length - 1);
	}

	private static void mergeSort(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			mergeSort(lowerIndex, middle);
			mergeSort(middle + 1, higherIndex);
			merge(lowerIndex, middle, higherIndex);
		}
	}

	private static void merge(int lowerIndex, int middleIndex, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			temporaryArray[i] = array[i];
		}
		int i = lowerIndex;
		int j = middleIndex + 1;
		int k = lowerIndex;

		while (i <= middleIndex && j <= higherIndex) {
			if (temporaryArray[i] <= temporaryArray[j]) {
				array[k] = temporaryArray[i];
				i++;
			} else {
				array[k] = temporaryArray[j];
				j++;
			}
			k++;
		}
		while (i <= middleIndex) {
			array[k] = temporaryArray[i];
			k++;
			i++;
		}
	}
}
