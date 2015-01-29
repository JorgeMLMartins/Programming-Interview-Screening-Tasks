package Triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Node {

	private int pathWeight;
	private int weight;
	private Node MSTParent;
	private ArrayList<Node> children = new ArrayList<Node>();
	private Vector<Integer> coordinate;
	
	public Node(int weight, int x, int y) {
		this.weight = weight;
		this.pathWeight = Integer.MAX_VALUE;
		this.coordinate = new Vector<Integer>();
		this.coordinate.add(0, x);
		this.coordinate.add(1, y);
	}
	
	public void addChildNode(Node node) {
		children.add(node);
	}
	
	public ArrayList<Node> getChildren() {
		return children;
	}
	
	public void setPathWeight(int weight) {
		pathWeight = weight;
	}
	
	public int getPathWeight() {
		return pathWeight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Node getMSTParent() {
		return MSTParent;
	}
	
	public void setMSTParent(Node parent) {
		MSTParent = parent;
	}
	
	public Vector<Integer> getCoordinate() {
		return coordinate;
	}
	
	public int[] getPathFromRoot() {
		ArrayList<Integer> weightList = new ArrayList<Integer>();
		Node currentNode = this;
		while(true) {
			weightList.add(currentNode.getWeight());
			currentNode = currentNode.getMSTParent();
			if (currentNode == null) break;
		}
	    Collections.reverse(weightList);
		return convertIntArray(weightList);
	}
	
	private static int[] convertIntArray(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    Iterator<Integer> iterator = integers.iterator();
	    for (int i = 0; i < ret.length; i++)
	    {
	        ret[i] = iterator.next().intValue();
	    }
	    return ret;
	}
}
