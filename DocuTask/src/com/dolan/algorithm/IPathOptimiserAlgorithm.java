package com.dolan.algorithm;

import java.util.List;

import com.dolan.graph.node.Coordinate;
import com.dolan.graph.node.INode;

public interface IPathOptimiserAlgorithm {
	int optimisePath(Coordinate startCoordinate, List<INode> path);
}
