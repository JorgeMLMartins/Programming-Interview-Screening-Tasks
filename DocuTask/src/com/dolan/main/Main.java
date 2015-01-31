package com.dolan.main;

import java.util.Scanner;

import com.dolan.graph.IMapData;
import com.dolan.graph.MapData;
import com.dolan.graph.exceptions.MapSizeMismatchException;

public class Main {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int[] input1 = stringArraytoIntArray(scanner.nextLine().split("\\s+"));
		int width = input1[0];
		int height = input1[1];
		IMapData mapData = new MapData(width, height);
		
		for (int i = 0; i < height; i++) {
			int[] row = stringArraytoIntArray(scanner.nextLine().split("\\s+"));
			try {
				mapData.addRow(row);
			} catch (MapSizeMismatchException e) {
				e.printStackTrace();
			}
		}
		
		scanner.close();
	}
	
	private static int[] stringArraytoIntArray(String[] stringArray) {
		int[] numbers = new int[stringArray.length];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(stringArray[i]);
		}
		return numbers;
	}
}
