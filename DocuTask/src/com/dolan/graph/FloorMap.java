package com.dolan.graph;

import com.dolan.graph.node.INode;

public class FloorMap implements IFloorMap {

	INode[][] nodes;
	public FloorMap(INode[][] nodes) {
		this.nodes = nodes;
	}
	@Override
	public INode[][] getNodes() {
		return this.nodes;
	}
}
