package com.dolan.graph;

import com.dolan.graph.node.INode;

public interface IFloorMap {
	void addNode(INode node);
	
	void addAdjacentNode(INode node, INode adjacent);
}
