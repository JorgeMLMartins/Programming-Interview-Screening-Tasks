package instructions;

public class InstructionFactory implements IInstructionFactory {

	@Override
	public Instruction newInstance(String token, String number) {
		return new Instruction(token.trim(), Integer.parseInt(number.trim()));
	}

}
