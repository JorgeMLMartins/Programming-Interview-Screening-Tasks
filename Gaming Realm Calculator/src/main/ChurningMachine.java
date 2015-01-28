package main;

import instructions.IInstructionSet;
import instructions.Instruction;

import java.util.List;
import java.util.Map;

import operators.IArithmetic;
import calculator.IOperatorSet;
import exceptions.NoInstructionFoundException;

public class ChurningMachine implements IChurningMachine {

	private IOperatorSet operators;
	private IInstructionSet instructionSet;

	public ChurningMachine(IOperatorSet operators, IInstructionSet instructions) {
		this.operators = operators;
		this.instructionSet = instructions;
	}
	
	@Override
	public int calculate() {
		if (instructionSet == null) throw new NullPointerException("No instruction set.");
		List<Instruction> instructions = this.instructionSet.getInstructions();
		
		int currentValue = instructions.get(instructions.size() - 1).getNumber();

		Map<String, IArithmetic> operators = this.operators.getOperators();
		
		for (int i = 0; i < instructions.size() - 1; i++) {
			String token = instructions.get(i).getToken();
			int toBeOperatedOn = instructions.get(i).getNumber();
			
			if (!operators.containsKey(token)) throw new NoInstructionFoundException("The instruction " + token + " cannot be found in the class files. Please check.");
			currentValue = singleCalculate(currentValue, toBeOperatedOn, operators.get(token));
		}
		
		return currentValue;
	}
	
	private int singleCalculate(int currentValue, int toBeOperatedOn, IArithmetic operator) {
		return operator.calculate(currentValue, toBeOperatedOn);
	}
	
	@Override
	public void setInstructionSet(IInstructionSet instructionSet) {
		this.instructionSet = instructionSet;
	}
}
