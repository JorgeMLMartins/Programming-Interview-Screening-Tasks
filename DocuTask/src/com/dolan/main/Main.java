package com.dolan.main;

import java.util.List;
import java.util.Scanner;

import com.dolan.algorithm.GreedyConnector;
import com.dolan.algorithm.IConnectorAlgorithm;
import com.dolan.algorithm.IPathOptimiserAlgorithm;
import com.dolan.algorithm.TravellingSalesmanAlgorithm;
import com.dolan.graph.IFloorMap;
import com.dolan.graph.IMapData;
import com.dolan.graph.MapData;
import com.dolan.graph.exceptions.MapSizeMismatchException;
import com.dolan.graph.factory.IMapFactory;
import com.dolan.graph.factory.MapFactory;
import com.dolan.graph.node.Coordinate;
import com.dolan.graph.node.INode;

public class Main {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int[] input1 = stringArraytoIntArray(scanner.nextLine().split("\\s+"));
		int width = input1[0];
		int height = input1[1];
		IMapData mapData = new MapData(width, height);

		for (int i = 0; i < height; i++) {
			int[] row = stringArraytoIntArray(scanner.nextLine().split(""));
			try {
				mapData.addRow(row);
			} catch (MapSizeMismatchException e) {
				e.printStackTrace();
			}
		}

		IMapFactory mapFactory = new MapFactory();
		IFloorMap floorMap = mapFactory.newInstance(mapData);

		IConnectorAlgorithm connector = new GreedyConnector();
		List<INode> path = connector.findConnections(floorMap.getNodes());

		IPathOptimiserAlgorithm pathAlgorithm = new TravellingSalesmanAlgorithm();
		int pathSize = pathAlgorithm.optimisePath(new Coordinate(0, 0), path);
		System.out.println(pathSize);
		//System.out.println(path);
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
