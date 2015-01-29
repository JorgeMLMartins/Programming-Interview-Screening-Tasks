package Triangle;

import java.util.ArrayList;

//Initially, I first wanted to create a complete tree, then generating the MST, then finding a path from that MST.
//This is inefficient, so I re-designed my approach and generated the MST straight from the text file.
public class Triangle {

	private Node parentNode;
	private int[][] triangleNumbers;
	private ArrayList<Node> openList = new ArrayList<Node>();
	
	public Triangle(String triangleString) {
		triangleNumbers = createTreeIntMatrix(triangleString);
		System.out.println("Created tree text");
		parentNode = new Node(7, 0, 0);
		//recursiveNodeCreate(0, 0, parentNode);
		MSTCreate(0, 0, parentNode);
	}
	
	public int[][] createTreeIntMatrix(String triangleString) {
		String[] lines = triangleString.split("\\n");
		int[][] numbers = new int[lines.length][lines[lines.length - 1].length() / 2];
		
		for (int i = 0; i < lines.length; i++) {
			String[] nodeWeights = lines[i].split(" ");
			for (int j = 0; j < nodeWeights.length; j++) {
				int weight = Integer.parseInt(nodeWeights[j]);			
				numbers[i][j] = weight;
			}
		}
		return numbers;
	}
	
	//Depreciated. This creates a complete model of the tree. However, it is computationally expensive.
	private void recursiveNodeCreate(int x, int y, Node parent) {
		if (triangleNumbers.length == x + 1) return;
		Node leftNode = findNode(x+1, y);
		Node rightNode = findNode(x+1, y+1);
			
		if (leftNode == null) {
			leftNode = new Node(triangleNumbers[x+1][y], x+1, y);
			openList.add(leftNode);
		}
		
		if (rightNode == null) {
			rightNode = new Node(triangleNumbers[x+1][y+1], x+1, y+1);
			openList.add(rightNode);
		}
		
		//parent.setLeftNode(leftNode);
		//parent.setRightNode(rightNode);
		//leftNode.setRightParent(parent);
		//rightNode.setLeftParent(parent);
		
		recursiveNodeCreate(x+1, y, leftNode);
		recursiveNodeCreate(x+1, y+1, rightNode);
	}
	
	//New method of making the MST straight from the text file.
	private void MSTCreate(int x, int y, Node parent) {
		openList.add(parent);
		parent.setPathWeight(parent.getWeight());
		while (true) {
			Node node = addShortestPathNode();
			if (node == null) break;
		}
	}
	
	private Node createNodeAt(int x, int y, Node parent) {
		int nodeWeight = triangleNumbers[x][y];
		Node node = new Node(nodeWeight, x, y);
		node.setMSTParent(parent);
		node.setPathWeight(parent.getPathWeight() + node.getWeight());
		parent.addChildNode(node);
		triangleNumbers[x][y] = -1;
		openList.add(node);
		return node;
	}
	
	private Node addShortestPathNode() {
		int lowestX = 0;
		int lowestY = 0;
		int lowestWeight = Integer.MAX_VALUE;
		Node parent = null;
		for(Node node : openList) {
			int x = node.getCoordinate().get(0);
			int y = node.getCoordinate().get(1);
			int leftNodeWeight;
			int rightNodeWeight;
			try {
				leftNodeWeight = triangleNumbers[x+1][y];
				rightNodeWeight = triangleNumbers[x+1][y+1];
			} catch(ArrayIndexOutOfBoundsException e) {
				continue;
			}
			
			if (leftNodeWeight != -1) {
				if (leftNodeWeight < lowestWeight) {
					lowestWeight = leftNodeWeight;
					lowestX = x+1;
					lowestY = y;
					parent = node;
				}
			}
			
			if (rightNodeWeight != -1) {
				if (rightNodeWeight < lowestWeight) {
					lowestWeight = leftNodeWeight;
					lowestX = x+1;
					lowestY = y+1;
					parent = node;
				}
			}
		}
		if (parent == null) return null;
		return createNodeAt(lowestX, lowestY, parent);
	}
	
	public int[] findShortestPath() {
		int bottomLayer = triangleNumbers.length - 1;
		int columns = triangleNumbers[0].length;
		
		int shortestPathLength = Integer.MAX_VALUE;
		Node shortestNode = null;
		for (int i = 0; i < columns; i++) {
			Node endNode = findNode(bottomLayer, i);
			if (endNode.getPathWeight() < shortestPathLength) {
				shortestPathLength = endNode.getPathWeight();
				shortestNode = endNode;
			}
		}
		return shortestNode.getPathFromRoot();
	}
	
	//Initially this function used a special traversal method to traverse the graph to find the node.
	//However this proved to be difficult because if the search algorithm goes down a route which doesn't have a connection
	//to the node in question, then it will not find the node.
	private Node findNode(int triangleLayer, int triangleNodeNumber) {
		/*Node node = parentNode;
		int traverseCounter = 0;
		for (int i = 0; i < triangleLayer; i++) {
			if (triangleNodeNumber > traverseCounter) {
				Node tempNode = node.getRightNode();
				if (tempNode == null) return null;
				node = tempNode;
			}
			
			if (triangleNodeNumber <= traverseCounter) {
				Node tempNode = node.getLeftNode();
				if (tempNode == null) return null;
				node = tempNode;
			}
			traverseCounter++;
		}
		return node;*/
		for (Node node : openList) {
			if (node.getCoordinate().get(0) == triangleLayer && node.getCoordinate().get(1) == triangleNodeNumber) {
				return node;
			}
		}
		return null;
	}
}
