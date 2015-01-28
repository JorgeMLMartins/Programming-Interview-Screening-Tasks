package calculator;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import operators.AddOperator;
import operators.IArithmetic;
import operators.SubtractOperator;

import org.junit.Test;

import exceptions.ExpectedException;

public class OperatorSetTests {

	@Test
	public void testIfCanProduceMaps() throws ClassNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("tests/testoperators.txt"));
		IArithmeticFactory factory = new ArithmeticFactory();
		IOperatorSet operatorSet = new OperatorSet(factory, br);
		Map<String, IArithmetic> map = operatorSet.getOperators();
		assertTrue(map.get("add") instanceof AddOperator);
		assertTrue(map.get("subtract") instanceof SubtractOperator);
	}
	
	@Test
	public void testIfCanDetectBadMap() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("tests/badoperators.txt")))
		{
			IArithmeticFactory factory = new ArithmeticFactory();
			IOperatorSet operatorSet = new OperatorSet(factory, br);
			throw new ExpectedException("Expected a class not found exception, but it didnth happen. Somethings wrong");
		} catch (ClassNotFoundException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void testBlankFile() throws ClassNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("tests/blankoperators.txt"));
		IArithmeticFactory factory = new ArithmeticFactory();
		IOperatorSet operatorSet = new OperatorSet(factory, br);
		Map<String, IArithmetic> map = operatorSet.getOperators();
		assertTrue(map.isEmpty());
	}
}
