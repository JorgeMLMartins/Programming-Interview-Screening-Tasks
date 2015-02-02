package com.dolan.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dolan.graph.node.INode;

public class FloorMap implements IFloorMap {

	private final Map<INode, List<INode>> adjacencyList;
	
	public FloorMap() {
		this.adjacencyList = new HashMap<INode, List<INode>>();
	}

	@Override
	public void addNode(INode node) {
		this.adjacencyList.put(node, new ArrayList<INode>());
	}

	@Override
	public void addAdjacentNode(INode node, INode adjacent) {
		List<INode> adjacentNodes = this.adjacencyList.get(node);
		adjacentNodes.add(adjacent);
	}
	
	
}
