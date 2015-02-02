package com.dolan.algorithm;

import java.util.Collections;
import java.util.List;

import com.dolan.graph.node.Coordinate;
import com.dolan.graph.node.INode;

public class TravellingSalesmanAlgorithm implements
		IPathOptimiserAlgorithm {

	public TravellingSalesmanAlgorithm() {

	}

	@Override
	public int optimisePath(Coordinate startCoordinate, List<INode> path) {
		int currentPathSize = estimatePath(path) + estimateTimeTravel(startCoordinate, path.get(0).getCoordinate());
		
		for (int i = 0; i < path.size(); i++) {
			for (int j = 0; j < path.size(); j++) {
				Collections.swap(path, i, j);
				//System.out.println("Swapping...");
				int pathSize = estimatePath(path) + estimateTimeTravel(startCoordinate, path.get(0).getCoordinate());
				if (pathSize > currentPathSize) {
					Collections.swap(path, j, i);
					//System.out.println("Less optimal route, swapping back...");
				} else {
					currentPathSize = pathSize;
				}
				//System.out.println("Current length of path: " + currentPathSize);
			}
		}
		return currentPathSize;
	}
		
	private int estimateTimeTravel(Coordinate coordinate1, Coordinate coordinate2) {
		int xDifference = Math.abs(coordinate1.x - coordinate2.x);
		int yDifference = Math.abs(coordinate1.y - coordinate2.y);

		return xDifference + yDifference;
	}

	private int estimatePath(List<INode> path) {
		int totalCost = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			totalCost += this.estimateTimeTravel(path.get(i).getCoordinate(), path.get(i + 1).getCoordinate());
		}
		return totalCost;
	}

}
