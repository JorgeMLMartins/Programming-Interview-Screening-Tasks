package com.dolan.graph.factory;

import com.dolan.graph.IFloorMap;
import com.dolan.graph.IMapData;

public interface IMapFactory {
	IFloorMap newInstance(IMapData mapData);
}
