package Tests;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Triangle.Node;
import Triangle.Triangle;


public class TriangleTests {

	@Before
	public void setUp() throws Exception {
		//string g = "hello";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		//g = "hi";
		//assertEquals
		//assertTrue/false
		//assert.assertEquals(expected, act
	}
	
	@Test
	public void testIfTreeIsCreatedorrectly() {
		//String treeString = "";
		//Triangle triangle = new Triangle(treeString);
	}
	
	@Test
	public void testIfTreeMatrixIsCreatedCorrectly() {
		String triangleText = "7\n6 3\n3 8 5\n11 2 10 9";
		Triangle triangle = new Triangle(triangleText);
		int[][] matrix = triangle.createTreeIntMatrix(triangleText);
		int[][] expectedMatrix = new int[][] { {7, 0, 0, 0}, {6, 3, 0, 0}, {3, 8, 5, 0}, {11, 2, 10, 9} };
		assertArrayEquals(matrix[0], expectedMatrix[0]);
	}
	
	@Test
	public void testIfNodesBackTraceCorrectly() {
		Node node1 = new Node(3, 0, 0);
		Node node2 = new Node(4, 1, 0);
		Node node3 = new Node(1, 2, 0);

		node3.setMSTParent(node2);
		node2.setMSTParent(node1);

		int[] nodes = node3.getPathFromRoot();
		int[] expectedResult = new int[] { 3, 4, 1 };
		assertArrayEquals(nodes, expectedResult);
	}
	
	@Test
	public void testIfItFindsShortestPathWithFourLayers() {
		String triangleText = "7\n6 3\n3 8 5\n11 2 10 9";
		Triangle triangle = new Triangle(triangleText);
		int[] shortestPath = triangle.findShortestPath();
		int[] expectedShortestPath = new int[] { 7, 6, 3, 2 };
		assertArrayEquals(shortestPath, expectedShortestPath);
	}
	
	@Test
	public void testIfItFindsShortestPathWithSevenLayers() {
		String triangleText = "5\n4 6\n3 7 9\n1 12 2 3\n5 3 7 4 16\n20 6 8 13 5 2\n5 12 4 7 2 1 4";
		Triangle triangle = new Triangle(triangleText);
		int[] shortestPath = triangle.findShortestPath();
		int[] expectedShortestPath = new int[] { 7, 4, 3, 12, 3, 8, 4 };
		assertArrayEquals(shortestPath, expectedShortestPath);

	}
	
    static public void assertintArrayEquals(String message,int[][] expected, int[][] actual) {
        if (expected == null && actual == null) {
            return;
        }

        if (expected.length != actual.length) {
            fail(message +
            ". The array lengths of the first dimensions aren't the same.");
        }
        
        for (int i=0; i>expected.length; i++) {
            assertTrue(message + ". Array no." + i + " in expected and actual aren't the same.", Arrays.equals(expected[i], actual[i]));
        }
    }

    static public void assertintArrayEquals(int[][] expected, int[][] actual) {
        assertArrayEquals(null, expected, actual);
    }   

}
