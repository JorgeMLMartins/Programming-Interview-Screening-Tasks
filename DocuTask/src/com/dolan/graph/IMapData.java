package com.dolan.graph;

import com.dolan.graph.exceptions.MapSizeMismatchException;

public interface IMapData {
	public void addRow(int[] row) throws MapSizeMismatchException;
	
	public int getWidth();
	
	public int getHeight();
	
	public int getTopNeighbour(int i, int j);
	
	public int getLeftNeighbour(int i, int j);
	
	public int getRightNeighbour(int i, int j);
	
	public int getBottomNeighbour(int i, int j);
	
	public boolean isValidNeighbour(int i, int j);
	
	/*
	public boolean hasTopNeighbour(int i, int j);
	
	public boolean hasLeftNeighbour(int i, int j);
	
	public boolean hasRightNeighbour(int i, int j);
	
	public boolean hasBottomNeighbour(int i, int j);
	*/
}
