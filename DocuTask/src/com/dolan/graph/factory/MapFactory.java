package com.dolan.graph.factory;

import com.dolan.graph.FloorMap;
import com.dolan.graph.IFloorMap;
import com.dolan.graph.IMapData;
import com.dolan.graph.node.Coordinate;
import com.dolan.graph.node.INode;
import com.dolan.graph.node.Apple;

public class MapFactory implements IMapFactory {

	@Override
	public IFloorMap newInstance(IMapData mapData) {
		IFloorMap map = new FloorMap();
		INode[][] nodes = new Apple[mapData.getWidth()][mapData.getHeight()];

		for (int i = 0; i < mapData.getWidth(); i++) {
			for (int j = 0; j < mapData.getHeight(); j++) {
				nodes[i][j] = new Apple(new Coordinate(i, j));
			}
		}

		for (int i = 0; i < mapData.getWidth(); i++) {
			for (int j = 0; j < mapData.getHeight(); j++) {
				map.addNode(nodes[i][j]);

				if (mapData.isValidNeighbour(i + 1, j)) {
					map.addAdjacentNode(nodes[i][j], nodes[i + 1][j]);
				}

				if (mapData.isValidNeighbour(i - 1, j)) {
					map.addAdjacentNode(nodes[i][j], nodes[i - 1][j]);
				}

				if (mapData.isValidNeighbour(i, j + 1)) {
					map.addAdjacentNode(nodes[i][j], nodes[i][j + 1]);
				}

				if (mapData.isValidNeighbour(i, j - 1)) {
					map.addAdjacentNode(nodes[i][j], nodes[i][j - 1]);
				}
			}
		}

		return map;
	}

}
