package Triangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TriangleApp {
	
	public static void main(String[] args) {
		String input = "";
		try {
			if (args.length == 0) throw new IOException();
			input = readTextFile(args[0]);
		} catch (IOException e) {
			System.out.println("Sorry, the file is invalid!");
			System.exit(0);
		}
		
		Triangle triangle = new Triangle(input);
		int[] pathNodes = triangle.findShortestPath();
		String pathNodeString = joinArray(pathNodes, " + ");
		System.out.println("Minimal Path is: " + pathNodeString + " = " + sumArray(pathNodes));
	}
	
	public static String readTextFile(String filename) throws IOException {
		String output = "";
		BufferedReader br = new BufferedReader(new FileReader(filename));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append('\n');
	            line = br.readLine();
	        }
	        output = sb.toString();
	    } finally {
	        br.close();
	    }
	    return output;
	}
	
	private static String joinArray(int[] array, String separator) {
		String output = "";
		for (int i = 0 ; i < array.length; i++) {
			output += array[i];
			if (i != array.length - 1) output += separator;
		}
		return output;
	}
	
	private static int sumArray(int[] array) {
		int sum = 0;
		for(int number : array) {
			sum += number;
		}
		return sum;
	}
}
