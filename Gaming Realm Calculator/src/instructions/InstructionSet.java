package instructions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidInstructionSetException;

public class InstructionSet implements IInstructionSet {

	private List<Instruction> instructions;
	private IInstructionFactory factory;
	private BufferedReader br;
	
	public InstructionSet(IInstructionFactory factory, BufferedReader br) throws IOException {
		this.factory = factory;
		this.instructions = new ArrayList<Instruction>();
		this.br = br;
		scanReader();
	}
	
	private void scanReader() throws IOException {
		String currentLine;
		String[] splitLine = null;
		while ((currentLine = br.readLine()) != null) {
			splitLine = currentLine.split("\\s+");
			//check if valid
			if (splitLine.length > 2) throw new InvalidInstructionSetException("File is formatted incorrectly. Please check");
			Instruction instruction = this.factory.newInstance(splitLine[0], splitLine[1]);
			this.instructions.add(instruction);
			
		}
		//blank file, which means this never gets initialised
		if (splitLine == null) return;
		System.out.println(splitLine[0]);
		//final check if it has apply on the end.
		if (!"apply".equals(splitLine[0])) throw new InvalidInstructionSetException("File is formatted incorrectly. Please check");
	}
	
	@Override
	public List<Instruction> getInstructions() {
		return this.instructions;
	}

}
