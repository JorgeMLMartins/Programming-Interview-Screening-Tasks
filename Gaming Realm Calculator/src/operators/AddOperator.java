package operators;

public class AddOperator implements IArithmetic {
	
	@Override
	public int calculate(int i, int j) {
		return i + j;
	}
}
