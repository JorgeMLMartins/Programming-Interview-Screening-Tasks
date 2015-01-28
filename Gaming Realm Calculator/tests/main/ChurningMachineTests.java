package main;

import static org.junit.Assert.assertEquals;
import instructions.IInstructionFactory;
import instructions.IInstructionSet;
import instructions.InstructionFactory;
import instructions.InstructionSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import calculator.ArithmeticFactory;
import calculator.IArithmeticFactory;
import calculator.IOperatorSet;
import calculator.OperatorSet;

public class ChurningMachineTests {
	
	public IChurningMachine machine;
	
	@Before
	public void setup() throws ClassNotFoundException, IOException {
		//I implemented dependency injection, which (as of currently) I believe to be the correct way to code.
		//Now I am setting up all the factories and buffered readers which is a link to the physical file.
		IArithmeticFactory operatorFactory = new ArithmeticFactory();
		BufferedReader operatorBufferedReader = new BufferedReader(new FileReader("tests/testoperators.txt"));
		//The churning machine needs a set of operators so it knows what its doing.
		//all operators are in the operators package. At the moment, it has Subtract, Multiply, Divide and Add. But you can be creative and do power, absolute, ceiling, bit shift, anything. It is VERY extensible.
		//All you need to do is implement the Arithmetic interface.
		IOperatorSet operatorSet = new OperatorSet(operatorFactory, operatorBufferedReader);
			
		//This is the beast. I chose not to dependency inject the instructions as they will change depending on the tests.
		machine = new ChurningMachine(operatorSet, null);
	}

	@Test
	public void testChurningMachine() throws IOException {
		//As the same as the operators, it reads the instructions with a buffered reader and everything is dependency injected.
		//I will be going to dependency injection heaven at this rate... Or maybe dependency injected into heaven.
		//Instruction Set is using a hash map internally, which is O(1). None of that switch case, or for loop nonsense.
		IInstructionFactory instructionFactory = new InstructionFactory();
		
		//The instruction set also has basic validation. So it wont run if it doesnt contain the apply keyword at the end, or if there are more parameters, or if the parameters are not strictly [String int] e.g. add 3.
		BufferedReader instructionBufferedReader = new BufferedReader(new FileReader("tests/testinstructions.txt"));
		IInstructionSet instructionSet = new InstructionSet(instructionFactory, instructionBufferedReader);
		
		machine.setInstructionSet(instructionSet);
		//Simple calculate method will invoke the process
		assertEquals(machine.calculate(), 15);
	}
	
	@Test
	public void testChurningMachine2() throws IOException {
		IInstructionFactory instructionFactory = new InstructionFactory();
		BufferedReader instructionBufferedReader = new BufferedReader(new FileReader("tests/testinstructions2.txt"));
		IInstructionSet instructionSet = new InstructionSet(instructionFactory, instructionBufferedReader);
		
		machine.setInstructionSet(instructionSet);
		assertEquals(machine.calculate(), 45);
	}
	
	@Test
	public void testChurningMachine3() throws IOException {
		IInstructionFactory instructionFactory = new InstructionFactory();
		BufferedReader instructionBufferedReader = new BufferedReader(new FileReader("tests/testinstructions3.txt"));
		IInstructionSet instructionSet = new InstructionSet(instructionFactory, instructionBufferedReader);
		
		machine.setInstructionSet(instructionSet);
		assertEquals(machine.calculate(), 1);
	}
}
