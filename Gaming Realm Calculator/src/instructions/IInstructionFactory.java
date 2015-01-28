package instructions;

public interface IInstructionFactory {

	Instruction newInstance(String token, String number);
}
