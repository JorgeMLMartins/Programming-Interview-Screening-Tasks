package com.dolan.algorithm;

import java.util.List;

import com.dolan.graph.node.INode;

public interface IConnectorAlgorithm {
	List<INode> findConnections(INode[][] nodes);
}
