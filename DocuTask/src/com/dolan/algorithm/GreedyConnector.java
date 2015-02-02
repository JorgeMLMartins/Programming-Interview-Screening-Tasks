package com.dolan.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.dolan.graph.node.Apple;
import com.dolan.graph.node.INode;

public class GreedyConnector implements IConnectorAlgorithm {

	@Override
	public List<INode> findConnections(INode[][] nodes) {
		List<INode> path = new ArrayList<INode>();
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[0].length; j++) {
				INode currentNode = nodes[i][j];

				if (currentNode instanceof Apple) {
					path.add(currentNode);
				}
			}
		}
		return path;
	}

}
