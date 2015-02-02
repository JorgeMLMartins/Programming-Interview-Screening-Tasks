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
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public int getNodeValue(int i, int j) {
		return this.lines[i][j];
	}

}
