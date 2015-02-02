package com.dolan.graph.factory;

import com.dolan.graph.FloorMap;
import com.dolan.graph.IFloorMap;
import com.dolan.graph.IMapData;
import com.dolan.graph.node.Apple;
import com.dolan.graph.node.Coordinate;
import com.dolan.graph.node.Ground;
import com.dolan.graph.node.INode;

public class MapFactory implements IMapFactory {

	@Override
	public IFloorMap newInstance(IMapData mapData) {
		INode[][] nodes = new INode[mapData.getWidth()][mapData.getHeight()];

		for (int i = 0; i < mapData.getWidth(); i++) {
			for (int j = 0; j < mapData.getHeight(); j++) {
				if (mapData.getNodeValue(i, j) == 1) {
					nodes[i][j] = new Apple(new Coordinate(i, j));
				} else {
					nodes[i][j] = new Ground();
				}
			}
		}
		IFloorMap map = new FloorMap(nodes);
		return map;
	}

}
