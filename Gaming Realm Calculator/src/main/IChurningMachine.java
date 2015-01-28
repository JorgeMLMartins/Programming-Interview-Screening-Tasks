package main;

import instructions.IInstructionSet;


public interface IChurningMachine {

	int calculate();
	public void setInstructionSet(IInstructionSet instructionSet);
}
