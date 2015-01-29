package Triangle;

import java.util.ArrayList;

//This version accepts a complete tree and generates a MST. It is sub optimal, so I created a better version.
//The better version creates the Minimum Spanning tree upon runtime, which is more efficient and faster.
//It saves having to build a complete tree first.
//This version has a run(Triangle triangle) method which marks the nodes if its part of the MST.
//I left the code as it is in case you want to look over it.

public class PathAlgorithm {
	
	private static ArrayList<Node> openList = new ArrayList<Node>();
	
	public static void run(Triangle triangle) {
		/*Node parent = triangle.getParentNode();
		openList.add(parent);
		
		while (true) {
			ArrayList<Node> nodes = findNodesFromOpenList();
			if (nodes.size() == 0) break;
			Node nextNode = findShortestWeightNode(nodes);
			addNodeToMST(nextNode);
		}*/
	}
	
	private static ArrayList<Node> findNodesFromOpenList() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (Node node : openList) {
			ArrayList<Node> childNodes = node.getChildren();
			for (Node childNode : childNodes) {
				if (childNode.getMSTParent() == null) {
					nodes.add(childNode);
				}
			}
		}
		return nodes;
	}
	
	private static void addNodeToMST(Node node) {
		/*openList.add(node);
		Node parent;
		Node rightParent = node.getRightParent();
		Node leftParent = node.getLeftParent();
		if (rightParent == null) {
			parent = leftParent;
		} else {
			parent = rightParent;
		}
		node.setMSTParent(parent);
		node.setPathWeight(parent.getPathWeight() + node.getWeight());*/
	}
	
	private static Node findShortestWeightNode(ArrayList<Node> nodes) {
		int shortestWeight = Integer.MAX_VALUE;
		Node shortestNode = null;
		for (Node node : nodes) {
			int weight = node.getWeight();
			if (shortestWeight > weight) {
				shortestNode = node;
				shortestWeight = weight;
			}
		}
		return shortestNode;
	}
}
