package com.dolan.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FloorMap implements IFloorMap {

	private final Map<INode, List<INode>> adjacencyList;
	
	public FloorMap() {
		this.adjacencyList = new HashMap<INode, List<INode>>();
	}

	@Override
	public void addNode(INode node) {
		this.adjacencyList.put(node, new ArrayList<INode>());
	}
	
	
}
