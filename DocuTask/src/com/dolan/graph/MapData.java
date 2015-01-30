package com.dolan.graph;

import com.dolan.graph.exceptions.MapSizeMismatchException;

public class MapData implements IMapData {
	private final int width;
	private final int height;
	private final int[][] lines;

	private int lineRowCount;

	public MapData(int width, int height) {
		this.width = width;
		this.height = height;
		this.lines = new int[width][height];
	}

	private boolean checkCoordinates(int i, int j) {
		if (i < 0 || j < 0 || i > this.width - 1 || j > this.height - 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void addRow(int[] row) throws MapSizeMismatchException {
		if (lineRowCount > this.height || row.length > this.width) {
			throw new MapSizeMismatchException(
					"Attempting to add another line which will exceed its height or width: "
							+ this.height + ", " + this.width);
		}

		this.lines[lineRowCount] = row;
		lineRowCount++;
	}

	@Override
	public int getTopNeighbour(int i, int j) {
		int newj = j - 1;
		return this.lines[i][newj];
	}

	@Override
	public int getLeftNeighbour(int i, int j) {
		int newi = i - 1;
		return this.lines[newi][j];
	}

	@Override
	public int getRightNeighbour(int i, int j) {
		int newi = i + 1;
		return this.lines[newi][j];
	}

	@Override
	public int getBottomNeighbour(int i, int j) {
		int newj = j + 1;
		return this.lines[i][newj];
	}

	@Override
	public boolean hasTopNeighbour(int i, int j) {
		return this.checkCoordinates(i, j + 1);
	}

	@Override
	public boolean hasLeftNeighbour(int i, int j) {
		return this.checkCoordinates(i - 1, j);
	}

	@Override
	public boolean hasRightNeighbour(int i, int j) {
		return this.checkCoordinates(i + 1, j);
	}

	@Override
	public boolean hasBottomNeighbour(int i, int j) {
		return this.checkCoordinates(i, j + 1);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

}
