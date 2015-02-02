package com.dolan.graph.node;


public class Apple implements INode {
	
	private Coordinate coordinate;
	
	public Apple(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	@Override
	public String toString() {
		return this.coordinate.toString();
	}
}
