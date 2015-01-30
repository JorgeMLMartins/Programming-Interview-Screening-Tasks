package com.dolan.graph.factory;

import com.dolan.graph.IFloorMap;
import com.dolan.graph.IMapData;
import com.dolan.graph.FloorMap;


public class MapFactory implements IMapFactory {

	@Override
	public IFloorMap newInstance(IMapData mapData) {
		IFloorMap map = new FloorMap();
		
		for (int i = 0; i < mapData.getWidth(); i++) {
			for (int j = 0; j < mapData.getHeight(); j++) {
				
				//if (mapData.hasBottomNeighbour(i, j)) {
				//	int neighbour = mapData.getBottomNeighbour(i, j);
				//}
			}
		}
		
		return map;
	}

}
